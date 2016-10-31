package com.kevin.lucene;


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
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LuceneTest {

    String WIN_INDEX_PATH = "c:temp/mirs/indexes/";
    String DEFAULT_INDEX_PATH = "/tmp/mirs/indexes/";

    @Test
    public void testLucene() throws IOException, ParseException {
        Analyzer analyzer = new StandardAnalyzer();

        // Store the index in memory:
//        Directory directory = new RAMDirectory();
        // To store an index on disk, use this instead:
        String indexPath;
        if(System.getProperty("os.name").substring(0, 3).equals("Win")){
            indexPath = WIN_INDEX_PATH;
        } else {
            indexPath = DEFAULT_INDEX_PATH;
        }
        Path path = Paths.get(indexPath);
        Directory directory = FSDirectory.open(path);
        System.out.println(path);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed.";
        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("text");
        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        //assertEquals(1, hits.length);
        System.out.println(1 == hits.length);
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
            System.out.println(hitDoc.get("fieldname"));
        }
        ireader.close();
        directory.close();
    }



}
