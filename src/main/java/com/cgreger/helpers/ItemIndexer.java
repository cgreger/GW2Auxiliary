package com.cgreger.helpers;

import com.cgreger.persistence.DBItemDAO;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by katana on 5/1/17.
 */
public class ItemIndexer {

    public static void main(String args[]) throws IOException, ParseException {

        DBItemDAO dbItemDAO = new DBItemDAO();
        //dbItemDAO.updateItemIndex();
        dbItemDAO.testIndexes();

    }

}
