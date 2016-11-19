package com.kevin.mirs.dao;

import com.kevin.mirs.enums.MovieColumnEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MovieDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    MovieDao movieDao;

    @Test
    public void getMovieById() throws Exception {
        System.out.println(movieDao.getMovieById(5));
    }

    @Test
    public void getMovieByDoubanId() throws Exception {
        System.out.println(movieDao.getMovieByDoubanId("1"));
    }

    @Test
    public void getAllMovie() throws Exception {
        System.out.println(movieDao.getMovies(MovieColumnEnum.columnOf(6), 10, 0));
    }

    @Test
    public void getMovieByMovieName() throws Exception {
        System.out.println(movieDao.getMovieByMovieName("name"));

    }

    @Test
    public void getMoviesIncludeMovieName() throws Exception {
        System.out.println(movieDao.getMoviesIncludeMovieName("", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesByDoubanRating() throws Exception {
        System.out.println(movieDao.getMoviesByDoubanRating("1.4", "8.4", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesByIMDbRating() throws Exception {
        System.out.println(movieDao.getMoviesByIMDbRating("1.4", "5.4", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesByReleaseYear() throws Exception {
        System.out.println(movieDao.getMoviesByReleaseYear("2000", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesByReleaseYears() throws Exception {
        System.out.println(movieDao.getMoviesByReleaseYears("1900", "2000", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesByRuntime() throws Exception {
        System.out.println(movieDao.getMoviesByRuntime("23", "300", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeDirector() throws Exception {
        System.out.println(movieDao.getMoviesIncludeDirector("大卫", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeScreenwriter() throws Exception {
        System.out.println(movieDao.getMoviesIncludeScreenwriter("大卫", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeActor() throws Exception {
        System.out.println(movieDao.getMoviesIncludeActor("大卫", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeType() throws Exception {
        System.out.println(movieDao.getMoviesIncludeType("喜剧", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeOriginPlace() throws Exception {
        System.out.println(movieDao.getMoviesIncludeOriginPlace("美国", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeLanguage() throws Exception {
        System.out.println(movieDao.getMoviesIncludeLanguage("中文", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeAnotherName() throws Exception {
        System.out.println(movieDao.getMoviesIncludeAnotherName("大卫", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getMoviesIncludeAward() throws Exception {
        System.out.println(movieDao.getMoviesIncludeAward("大卫", MovieColumnEnum.columnOf(1), 10, 0));
    }

    @Test
    public void getSuggestedMovie() throws Exception {
        System.out.println(movieDao.getSuggestedMovie(3));
    }

    @Test
    public void getRandomSimpleMovies() throws Exception {
        System.out.println(movieDao.getRandomSimpleMovies(1));
    }


}