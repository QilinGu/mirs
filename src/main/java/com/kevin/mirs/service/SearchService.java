package com.kevin.mirs.service;


import com.kevin.mirs.dao.MovieDao;
import com.kevin.mirs.entity.Movie;
import com.kevin.mirs.enums.MovieColumnEnum;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class SearchService {

    private final String[] fields = {
            MovieColumnEnum.NAME.getName(),
            MovieColumnEnum.DIRECTORS.getName(),
            MovieColumnEnum.SCREENWRITERS.getName(),
            MovieColumnEnum.ACTORS.getName(),
            MovieColumnEnum.TYPES.getName(),
            MovieColumnEnum.ORIGIN_PLACE.getName(),
            MovieColumnEnum.LANGUAGES.getName(),
            MovieColumnEnum.SYNOPSIS.getName()
    };

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    Analyzer analyzer;

    @Resource
    IndexWriter indexWriter;

    @Resource
    IndexSearcher indexSearcher;

    @Resource
    MovieDao movieDao;


    /**
     * 将数据库中的电影信息进行索引，方便后续查找
     * <p>
     * TextField.TYPE_STORED 与 TextField.TYPE_NOT_STORED都是FieldType()类型
     * 都设置了分词，唯一区别在于是否储存
     */
    public void indexMovie() {
        int limit = 100;
        int offset = 0;
        ArrayList<Movie> movieArrayList;

        // 当movieArrayList不为空
        while (!(movieArrayList = movieDao.getMovies(MovieColumnEnum.columnOf(1), limit, offset)).isEmpty()) {
            offset += limit;
            System.out.println(offset);
            for (Movie movie : movieArrayList) {
                logger.info("即将索引电影：" + movie.getName());
                Document document = new Document();
                document.add(new Field(MovieColumnEnum.ID.getName(), movie.getId().toString(), TextField.TYPE_STORED));
                if (movie.getDoubanId() != null && movie.getDoubanId() != "") {
                    document.add(new Field(MovieColumnEnum.DOUBAN_ID.getName(), movie.getDoubanId(), TextField.TYPE_STORED));
                }
                if (movie.getName() != null && movie.getName() != "") {
                    document.add(new Field(MovieColumnEnum.NAME.getName(), movie.getName(), TextField.TYPE_STORED));
                }
                if (movie.getDirectors() != null && movie.getDirectors() != "") {
                    document.add(new Field(MovieColumnEnum.DIRECTORS.getName(), movie.getDirectors(), TextField.TYPE_NOT_STORED));
                }
                if (movie.getScreenwriters() != null && movie.getScreenwriters() != "") {
                    document.add(new Field(MovieColumnEnum.SCREENWRITERS.getName(), movie.getScreenwriters(), TextField.TYPE_NOT_STORED));
                }
                if (movie.getActors() != null && movie.getActors() != "") {
                    document.add(new Field(MovieColumnEnum.ACTORS.getName(), movie.getActors(), TextField.TYPE_NOT_STORED));
                }
                if (movie.getTypes() != null && movie.getTypes() != "") {
                    document.add(new Field(MovieColumnEnum.TYPES.getName(), movie.getTypes(), TextField.TYPE_NOT_STORED));
                }
                if (movie.getOriginPlace() != null && movie.getOriginPlace() != "") {
                    document.add(new Field(MovieColumnEnum.ORIGIN_PLACE.getName(), movie.getOriginPlace(), TextField.TYPE_NOT_STORED));
                }
                if (movie.getLanguages() != null && movie.getLanguages() != "") {
                    document.add(new Field(MovieColumnEnum.LANGUAGES.getName(), movie.getLanguages(), TextField.TYPE_NOT_STORED));
                }
                if (movie.getSynopsis() != null && movie.getSynopsis() != "") {
                    document.add(new Field(MovieColumnEnum.SYNOPSIS.getName(), movie.getSynopsis(), TextField.TYPE_NOT_STORED));
                }

                try {
                    indexWriter.addDocument(document);
                    indexWriter.commit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logger.info("索引电影：" + movie.getId() + "完成");
            }
        }
    }

    /**
     * 按照指定条件查询电影信息
     */
    public ArrayList<Movie> searchMovie(String keyword) {

        ArrayList<Movie> movieArrayList = new ArrayList<Movie>();

        try {
            QueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
            Query query = queryParser.parse(keyword);
            ScoreDoc[] scoreDocs = indexSearcher.search(query, 10).scoreDocs;
            for(ScoreDoc scoreDoc: scoreDocs) {
                Document document = indexSearcher.doc(scoreDoc.doc);
                System.out.println("编号为"+document.get("id")+"号的电影得分是" + scoreDoc.score);

                Movie movie = movieDao.getMovieById(document.get("id"));
                movieArrayList.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieArrayList;
    }


    public void deleteAllIndexes() {
        try {
            indexWriter.deleteAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
