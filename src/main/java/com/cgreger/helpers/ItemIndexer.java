package com.cgreger.helpers;

import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;

/**
 *
 */
public class ItemIndexer {

    public static void main(String args[]) throws IOException, ParseException {

        LuceneUtils lutil = new LuceneUtils();
        lutil.indexItems();

        System.exit(0);

    }

}
