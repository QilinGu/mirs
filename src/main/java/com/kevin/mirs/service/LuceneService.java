package com.kevin.mirs.service;

import com.kevin.mirs.dao.MovieDao;
import com.kevin.mirs.entity.Movie;
import com.kevin.mirs.enums.MovieColumnEnum;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Lucene 的相关操作,如系统参数配置等
 */
@Service
public class LuceneService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    Analyzer analyzer;

    @Resource
    IndexWriter indexWriter;

    @Resource
    MovieDao movieDao;


    /**
     * 将数据库中的电影信息进行索引，方便后续查找
     * 系统开始时进行索引
     * <p>
     * TextField.TYPE_STORED 与 TextField.TYPE_NOT_STORED都是FieldType()类型
     * 都设置了分词，唯一区别在于是否储存
     *
     * TODO 自定义Similarity 实现更加用户友好的结果排序，比如按照年份和评分
     */
    @PostConstruct
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

                // 添加索引的段，并设置权值
                if (movie.getId() != null) {
                    Field field = new Field(MovieColumnEnum.ID.getName(), movie.getId().toString(), TextField.TYPE_STORED);
                    field.setBoost(MovieColumnEnum.ID.getBoost());
                    document.add(field);
                }
                if (movie.getName() != null && movie.getName() != "") {
                    Field field = new Field(MovieColumnEnum.NAME.getName(), movie.getName(), TextField.TYPE_STORED);
                    field.setBoost(MovieColumnEnum.NAME.getBoost());
                    document.add(field);
                }
                if (movie.getReleaseYear() != null && movie.getReleaseYear() != "") {
                    Field field = new Field(MovieColumnEnum.RELEASE_YEAR.getName(), movie.getReleaseYear(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.RELEASE_YEAR.getBoost());
                    document.add(field);
                }

                if (movie.getDirectors() != null && movie.getDirectors() != "") {
                    Field field = new Field(MovieColumnEnum.DIRECTORS.getName(), movie.getDirectors(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.DIRECTORS.getBoost());
                    document.add(field);
                }
                if (movie.getScreenwriters() != null && movie.getScreenwriters() != "") {
                    Field field = new Field(MovieColumnEnum.SCREENWRITERS.getName(), movie.getScreenwriters(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.SCREENWRITERS.getBoost());
                    document.add(field);
                }
                if (movie.getActors() != null && movie.getActors() != "") {
                    Field field = new Field(MovieColumnEnum.ACTORS.getName(), movie.getActors(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.ACTORS.getBoost());
                    document.add(field);
                }
                if (movie.getTypes() != null && movie.getTypes() != "") {
                    Field field = new Field(MovieColumnEnum.TYPES.getName(), movie.getTypes(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.TYPES.getBoost());
                    document.add(field);
                }
                if (movie.getOriginPlace() != null && movie.getOriginPlace() != "") {
                    Field field = new Field(MovieColumnEnum.ORIGIN_PLACE.getName(), movie.getOriginPlace(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.ORIGIN_PLACE.getBoost());
                    document.add(field);
                }
                if (movie.getLanguages() != null && movie.getLanguages() != "") {
                    Field field = new Field(MovieColumnEnum.LANGUAGES.getName(), movie.getLanguages(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.LANGUAGES.getBoost());
                    document.add(field);
                }
                if (movie.getAnotherNames() != null && movie.getAnotherNames() != "") {
                    Field field = new Field(MovieColumnEnum.ANOTHER_NAMES.getName(), movie.getAnotherNames(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.ANOTHER_NAMES.getBoost());
                    document.add(field);
                }
                if (movie.getCoverLink() != null && movie.getCoverLink() != "") {
                    Field field = new Field(MovieColumnEnum.COVER_LINK.getName(), movie.getCoverLink(), TextField.TYPE_STORED);
                    field.setBoost(MovieColumnEnum.COVER_LINK.getBoost());
                    document.add(field);
                }

                if (movie.getSynopsis() != null && movie.getSynopsis() != "") {
                    Field field = new Field(MovieColumnEnum.SYNOPSIS.getName(), movie.getSynopsis(), TextField.TYPE_NOT_STORED);
                    field.setBoost(MovieColumnEnum.SYNOPSIS.getBoost());
                    document.add(field);
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
     * 删除所有的索引
     * 系统结束是进行清理
     */
    @PreDestroy
    public void deleteAllIndexes() {
        System.out.println("---------------删除索引-------------");
        try {
            indexWriter.deleteAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
