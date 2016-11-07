package com.kevin.mirs.service;


import com.kevin.mirs.dao.MovieDao;
import com.kevin.mirs.entity.Movie;
import com.kevin.mirs.enums.MovieColumnEnum;
import com.kevin.mirs.vo.SuggestionMovie;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class SearchService {

    private final String[] fields = {
            MovieColumnEnum.ID.getName(),
            MovieColumnEnum.NAME.getName(),
            MovieColumnEnum.RELEASE_YEAR.getName(),
            MovieColumnEnum.DIRECTORS.getName(),
            MovieColumnEnum.SCREENWRITERS.getName(),
            MovieColumnEnum.ACTORS.getName(),
            MovieColumnEnum.TYPES.getName(),
            MovieColumnEnum.ORIGIN_PLACE.getName(),
            MovieColumnEnum.LANGUAGES.getName(),
            MovieColumnEnum.ANOTHER_NAMES.getName(),
            MovieColumnEnum.COVER_LINK.getName(),
            MovieColumnEnum.SYNOPSIS.getName()
    };

    @Resource
    Analyzer analyzer;

    @Resource
    IndexSearcher indexSearcher;


    /**
     * 按照指定条件查询电影信息
     */
    public ArrayList<SuggestionMovie> searchMovie(String keyword) {



        ArrayList<SuggestionMovie> suggestionMovies = new ArrayList<SuggestionMovie>();

        try {
            QueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
            Query query = queryParser.parse(keyword);
            ScoreDoc[] scoreDocs = indexSearcher.search(query, 10).scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {
                Document document = indexSearcher.doc(scoreDoc.doc);
                System.out.println("编号为" + document.get("id") + "号的电影得分是" + scoreDoc.score);

                // 从数据库获取
                //SuggestionMovie s = movieDao.getSuggestedMovie(Integer.parseInt(document.get("id")));

                //直接获取
                SuggestionMovie s = new SuggestionMovie(
                        Integer.parseInt(document.get(MovieColumnEnum.ID.getName())),
                        document.get(MovieColumnEnum.NAME.getName()),
                        document.get(MovieColumnEnum.COVER_LINK.getName()));

                suggestionMovies.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(suggestionMovies);
        return suggestionMovies;
    }




}
