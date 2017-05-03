package com.cgreger.helpers;

import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
/**
 * Created by katana on 5/1/17.
 */
public class ItemIndexer {

    public static void main(String args[]) throws IOException, ParseException {

        LuceneUtils lutil = new LuceneUtils();
        lutil.indexItems();

        System.exit(0);

    }

}
