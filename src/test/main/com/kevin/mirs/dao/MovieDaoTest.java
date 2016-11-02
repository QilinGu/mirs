package com.kevin.mirs.dao;

import com.kevin.mirs.enums.MovieColumnEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MovieDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    MovieDao movieDao;

    @Test
    public void getMovieById() throws Exception {
        System.out.println(movieDao.getMovieById(1));
    }

    @Test
    public void getMovieByDoubanId() throws Exception {
        System.out.println(movieDao.getMovieByDoubanId("1"));
    }

    @Test
    public void getAllMovie() throws Exception {
        System.out.println(movieDao.getAllMovie(MovieColumnEnum.columnOf(6), 10, 0));
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


}