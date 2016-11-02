package com.kevin.mirs.service;


import com.kevin.mirs.dao.MovieDao;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SearchService {

    @Resource
    IndexWriter indexWriter;

    @Resource
    Document document;

    @Resource
    IndexSearcher indexSearcher;

    @Resource
    MovieDao movieDao;


    /**
     * 将数据库中的电影信息进行索引，方便后续查找
     */
    public void indexMovie() {

    }

    /**
     * 按照指定条件查询电影信息
     */
    public void SearchMovie() {

    }

}
