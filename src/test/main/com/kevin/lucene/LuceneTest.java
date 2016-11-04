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
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:junit/spring-test.xml"})
public class LuceneTest {

    @Resource
    Analyzer analyzer;

    @Resource
    IndexWriter indexWriter;

    @Resource
    Document document;

    @Resource
    IndexSearcher indexSearcher;


    @Test
    public void testLucene() throws IOException, ParseException {

        // Store the index in memory:
//        Directory directory = new RAMDirectory();
        // To store an index on disk, use this instead:
        String text = "jcseg是使用Java开发的一款开源的中文分词器, 基于流行的mmseg算法实现，" +
                "分词准确率高达98.4%, 支持中文人名识别, 同义词匹配, 停止词过滤等。" +
                "并且提供了最新版本的lucene,solr,elasticsearch分词接口。";
        document.add(new Field("fieldname", text, TextField.TYPE_STORED));
        indexWriter.addDocument(document);

        // Now search the index:
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("过滤");
        ScoreDoc[] hits = indexSearcher.search(query, 1000).scoreDocs;
        //assertEquals(1, hits.length);
        System.out.println(1 == hits.length);
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = indexSearcher.doc(hits[i].doc);
            //assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
            System.out.println(hitDoc.get("fieldname"));
        }
    }



}
