package com.kevin.mirs.service;


import com.kevin.mirs.enums.MovieColumnEnum;
import com.kevin.mirs.vo.SuggestionMovie;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class SearchService {

    private final String[] DEFAULT_FIELDS = {
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

    private final int DEFAULT_LIMIT = 6;

    @Resource
    Analyzer analyzer;

    @Resource
    IndexSearcher indexSearcher;


    /**
     * 按照指定条件查询电影信息
     */
    public ArrayList<SuggestionMovie> searchMovie(String keyword, int limit) {

        int searchLimit = (limit > 0) ? limit : DEFAULT_LIMIT;

        ArrayList<SuggestionMovie> suggestionMovies = new ArrayList<SuggestionMovie>();

        try {
            QueryParser queryParser = new MultiFieldQueryParser(DEFAULT_FIELDS, analyzer);
            Query query = queryParser.parse(keyword);
            ScoreDoc[] scoreDocs = indexSearcher.search(query, searchLimit).scoreDocs;
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
