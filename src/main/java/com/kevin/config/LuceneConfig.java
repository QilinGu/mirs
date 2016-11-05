package com.kevin.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.lionsoul.jcseg.analyzer.v5x.JcsegAnalyzer5X;
import org.lionsoul.jcseg.tokenizer.core.JcsegTaskConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
public class LuceneConfig {

    String WIN_INDEX_PATH = "c:temp/mirs/indexes/";
    String DEFAULT_INDEX_PATH = "/tmp/mirs/indexes/";

    @Bean
    public Analyzer analyzer() {
//        如果需要使用特定的分词算法，可通过构造函数来指定：
//        Analyzer analyzer = new ChineseWordAnalyzer(SegmentationAlgorithm.FullSegmentation);
//        如不指定，默认使用双向最大匹配算法：SegmentationAlgorithm.BidirectionalMaximumMatching
//        可用的分词算法参见枚举类：SegmentationAlgorithm
//        return new ChineseWordAnalyzer();
//        return new StandardAnalyzer();
        return new JcsegAnalyzer5X(JcsegTaskConfig.COMPLEX_MODE);
    }


    private Directory directory() throws IOException {
        String indexPath;
        if(System.getProperty("os.name").substring(0, 3).equals("Win")){
            indexPath = WIN_INDEX_PATH;
        } else {
            indexPath = DEFAULT_INDEX_PATH;
        }
        Path path = Paths.get(indexPath);
        return FSDirectory.open(path);
    }


    private IndexWriterConfig config() {
        return new IndexWriterConfig(analyzer());
    }


    @Bean
    public IndexWriter indexWriter() throws IOException {
        return new IndexWriter(directory(), config());
    }


    private IndexReader indexReader() throws IOException {
        return DirectoryReader.open(directory());
    }


    @Bean
    public IndexSearcher indexSearcher() throws IOException {
        return new IndexSearcher(indexReader());
    }
}
