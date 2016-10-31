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
    public void getMovieByMovieId() throws Exception {

        System.out.println(movieDao.getMovieByMovieId(1));

    }

    @Test
    public void getAllMovie() throws Exception {

        System.out.println(movieDao.getAllMovie());

    }

}