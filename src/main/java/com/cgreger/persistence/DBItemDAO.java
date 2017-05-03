package com.cgreger.persistence;

import com.cgreger.entity.api.Item;
import com.cgreger.entity.db.DBItem;
import com.cgreger.entity.db.TrackedItem;
import com.cgreger.entity.db.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import javax.ws.rs.BadRequestException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DBItemDAO {

    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private GW2ServiceClient gw2Client = new GW2ServiceClient();
    private ObjectMapper mapper = new ObjectMapper();

    private Logger log = Logger.getLogger(this.getClass());

    public DBItem getDBItemByName(String name) {

        Session session = factory.openSession();
        DBItem dbItem = null;

        try {

            log.info("Getting DBItem with name: " + name);

            Criteria criteria = session.createCriteria(DBItem.class);
            criteria = criteria.add(Restrictions.eq("name", name));
            List<DBItem> results = (List<DBItem>) criteria.list();

            if (results.size() >= 1) {

                log.info("Successfully retrieved DBItem with name: " + name);
                dbItem = results.get(0);

            } else {

                log.error("Failed to retrieve DBItem with name: " + name);

            }

        } catch (HibernateException e) {

            log.error("Failed to DBItem with name: " + name, e);

        } finally {

            session.close();

        }

        return dbItem;

    }

//    //get DBItem by id
//    public User getDBItemById(int userId) {
//
//        Session session = factory.openSession();
//        Transaction tr = null;
//        User user = null;
//
//        try {
//
//            log.info("Getting User (id" + userId + ").");
//
//            tr = session.beginTransaction();
//            user = (User) session.get(User.class, userId);
//
//            log.info("Successfully retrieved User (id" + userId + ")");
//
//        } catch (HibernateException e) {
//
//            if (tr != null) {
//
//                tr.rollback();
//
//            }
//
//            log.error("Failed to retrieve User (id" + userId + ")\n", e);
//
//        } finally {
//
//            session.close();
//
//        }
//
//        return user;
//
//    }

    public int addDBItem(DBItem dbItem) {

        Session session = factory.openSession();
        Transaction tr = null;
        Integer itemId = null;

        try {

            log.info("Adding new DBItem.");

            tr = session.beginTransaction();

            itemId = (Integer) session.save(dbItem);

            tr.commit();
            log.info("\n\nSuccessfully added new DBItem: \n\t"
                            + dbItem.getGw2Id()
                            + "\n\t" + dbItem.getName()
                            + "\n\t" + dbItem.getType() + "\n");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to add new DBItem" , e);

        } finally {

            session.close();

        }

        return itemId;

    }

    //TODO: UPDATE DBITEM Database
    public boolean updateItemDatabase(int maxPages) {

        boolean isSuccessful = false;
        String response = null;
        JsonNode items;
        double startTime = System.currentTimeMillis();
        double endTime;
        int updateDurationInMin;

        //TODO: useful for api strings - .replace("\"", "")tracked_item
        this.truncateItemDatabase();

        log.info("Updating Item database");
        try {

            for (int pageNumber = 0; pageNumber <= maxPages; pageNumber++) {

                response = gw2Client.request("https://api.guildwars2.com/v2/items?page=" + pageNumber + "&page_size=200");
                items = mapper.readValue(response, JsonNode.class);

                for (JsonNode item : items) {

                    DBItem dbItem = new DBItem(Integer.parseInt(item.get("id").toString()), item.get("name").toString().replace("\"", ""), item.get("type").toString().replace("\"", ""));
                    this.addDBItem(dbItem);

                }

            }

            isSuccessful = true;
            log.info("Successfully Updated Item database PARTIALLY (Processed number of pages lower than max pages)");

        } catch (IOException e) {

            e.printStackTrace();
            isSuccessful = false;

        } catch (BadRequestException bre) {

            //Met the end of the item pages, db updated.
            isSuccessful = true;
            log.info("Successfully Updated Item database COMPLETELY");

        }

        endTime = System.currentTimeMillis();
        updateDurationInMin = (int)(((endTime - startTime) / 1000 )/ 60);
        log.info("Update DB Duration: " + updateDurationInMin + " min");

        return isSuccessful;

    }

    public void testIndexes() throws IOException, ParseException {

        Analyzer analyzer = new StandardAnalyzer();
        Directory directory = FSDirectory.open(Paths.get("/home/katana/EnterpriseRepos/GW2Auxiliary/lucene/indexes/dbitemindex"));
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("item_name", analyzer);
        org.apache.lucene.search.Query query = parser.parse("shirt");
        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;

        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);

            log.info(hitDoc.getValues("item_name"));
            log.info(hits.length);
        }

        ireader.close();
        directory.close();

    }

    //Truncate Item Database
    public boolean truncateItemDatabase() {
        Session session = factory.openSession();
        Transaction tr = null;
        Query query;
        boolean isSuccessful = false;
        String tableName = "DBItem";

        try {

            log.info("Truncating Item database");

            tr = session.beginTransaction();

            String hql = "DELETE FROM " + tableName;
            query = session.createQuery(hql);
            query.executeUpdate();

            tr.commit();

            isSuccessful = true;

            log.info("Successfully Truncated Item database");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }
            isSuccessful = false;
            log.error("Failed to Truncate Item database" , e);

        } finally {

            session.close();

        }

        return isSuccessful;

    }

}
