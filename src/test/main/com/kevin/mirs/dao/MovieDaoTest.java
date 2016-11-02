package com.kevin.mirs.dao;

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
        System.out.println(movieDao.getAllMovie("release_year", 2, 1));
    }

    @Test
    public void getMovieByMovieName() throws Exception {
        System.out.println(movieDao.getMovieByMovieName("name"));

    }



}