package com.kevin.mirs.dao;

import com.kevin.mirs.entity.UserRecommendedMovies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserRecommendedMoviesDaoTest {

    @Resource
    UserRecommendedMoviesDao userRecommendedMoviesDao;

    @Test
    public void addUserRecommendedMovies() throws Exception {

        System.out.println(userRecommendedMoviesDao.addUserRecommendedMovies(1,1,1.0f));

    }

}