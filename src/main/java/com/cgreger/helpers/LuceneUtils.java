package com.cgreger.helpers;

import com.cgreger.entity.db.DBItem;
import com.cgreger.persistence.SessionFactoryProvider;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.complexPhrase.ComplexPhraseQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class LuceneUtils {

    private Logger log = Logger.getLogger(this.getClass());
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private ObjectMapper mapper = new ObjectMapper();
    private String itemIndexDirectory;


    public LuceneUtils() {

        //TODO: put dir in properties file

        this.itemIndexDirectory = "/home/katana/EnterpriseRepos/GW2Auxiliary/lucene/indexes/dbitemindex";

    }

    public LuceneUtils(String itemIndexDirectory) {

        this.itemIndexDirectory = itemIndexDirectory;

    }

    public boolean indexItems() {

        this.cleanItemIndex();

        boolean isSuccessful = false;
        double startTime = System.currentTimeMillis();
        double endTime;
        int updateDurationInMin;

        Session session = factory.openSession();

        Analyzer analyzer = null;
        Directory directory = null;
        IndexWriterConfig config = null;
        IndexWriter iwriter = null;


        try {

            log.info("Updating Item index");
            log.info("Path: " + this.itemIndexDirectory);

            // Get all the current DBItems
            List<DBItem> dbItems = session.createCriteria(DBItem.class).list();

            analyzer = new StandardAnalyzer();
            directory = FSDirectory.open(Paths.get(this.itemIndexDirectory));
            config = new IndexWriterConfig(analyzer);
            iwriter = new IndexWriter(directory, config);

            for (DBItem dbItem : dbItems) {

                Document doc = new Document();
                doc.add(new Field("gw2_id", Integer.toString(dbItem.getGw2Id()), TextField.TYPE_STORED));
                doc.add(new Field("item_name", dbItem.getName(), TextField.TYPE_STORED));
                doc.add(new Field("item_type", dbItem.getType(), TextField.TYPE_STORED));
                iwriter.addDocument(doc);

                log.info("Indexed Item -");
                log.info("Id: " + doc.getFields().get(doc.getFields().size() - 3));
                log.info("Name: " + doc.getFields().get(doc.getFields().size() - 2));
                log.info("Type: " + doc.getFields().get(doc.getFields().size() - 1) + "\n");

            }

            log.info("Successfully updated Item index");
            log.info("Path: " + this.itemIndexDirectory);


            isSuccessful = true;

        } catch (HibernateException e) {

            log.error("Failed to update Item index", e);
            isSuccessful = false;

        } catch (IOException ioe) {

            log.error("Failed to update Item index", ioe);
            isSuccessful = false;

        } finally {

            session.close();

            try {

                iwriter.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        endTime = System.currentTimeMillis();
        updateDurationInMin = (int)(((endTime - startTime) / 1000 )/ 60);
        log.info("Update Index Duration: " + updateDurationInMin + " min");

        return isSuccessful;

    }

    public JsonNode fuzzyQuery(String query) {

        JsonNode jsonHits = null;
        Analyzer analyzer = new StandardAnalyzer();
        Directory directory = null;
        IndexReader reader = null;
        int hitsPerPage = 10;

        try {

            directory = FSDirectory.open(Paths.get(this.itemIndexDirectory));

            String querystr = this.buildFuzzyQuery(query);
            //Query fuzzyQuery = new FuzzyQuery(new Term("item_name", querystr), 2);
            Query complexQuery = new ComplexPhraseQueryParser("item_name", analyzer).parse(querystr);

            reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(complexQuery, hitsPerPage);
            ScoreDoc[] hits = docs.scoreDocs;

            log.info("Found " + hits.length + " hits.");

            jsonHits = convertHitsToJSON(searcher, hits);

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException pe) {

            pe.printStackTrace();
        } finally {

            try {

                if (reader != null) {
                    reader.close();
                    directory.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return jsonHits;

    }

    private String buildFuzzyQuery(String query) {

        query = query.replaceAll("[^a-zA-Z0-9\\s]", "");
        List<String> queryTokens = Arrays.asList(query.split("\\s+"));

        String fuzzyQuery = "";

        for (String token : queryTokens) {

            fuzzyQuery += (token + "~ ");


        }


        log.info("\n" + fuzzyQuery);

        return fuzzyQuery;

    }

    private JsonNode convertHitsToJSON(IndexSearcher searcher, ScoreDoc[] hits) throws IOException {

        ArrayNode rootNode = mapper.createArrayNode();

        for (int i = 0; i < hits.length; ++i) {

            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            ObjectNode hitNode = mapper.createObjectNode();
            hitNode.put("gw2_id", d.get("gw2_id"));
            hitNode.put("item_name", d.get("item_name"));
            hitNode.put("item_type", d.get("item_type"));

            rootNode.add(hitNode);

        }

        //rootNode.toString() gives json string
        //mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode)) gives "pretty" json string
        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode));

        return rootNode;

    }

    private boolean cleanItemIndex() {

        boolean isSuccessful = false;

        //TODO: put file path in properties file
        try {

            File directory = new File(this.itemIndexDirectory);
            FileUtils.cleanDirectory(directory);
            isSuccessful = true;

        } catch (IOException e) {

            e.printStackTrace();
            isSuccessful = false;

        }

        return isSuccessful;

    }

}
