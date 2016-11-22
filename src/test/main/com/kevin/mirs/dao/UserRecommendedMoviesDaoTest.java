package com.kevin.mirs.dao;

import com.kevin.mirs.entity.UserRecommendedMovies;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.mahout.cf.taste.impl.recommender.GenericRecommendedItem;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserRecommendedMoviesDaoTest {

    @Resource
    UserRecommendedMoviesDao userRecommendedMoviesDao;

    @Test
    public void addUserRecommendedMovies() throws Exception {

        List<RecommendedItem> rms = new ArrayList();
        RecommendedItem ri1 = new GenericRecommendedItem(1, 0.7f);
        RecommendedItem ri2 = new GenericRecommendedItem(2, 0.5f);
        RecommendedItem ri3 = new GenericRecommendedItem(3, 0.6f);
        rms.add(ri1);
        rms.add(ri2);
        rms.add(ri3);
        System.out.println(userRecommendedMoviesDao.addUserRecommendedMovies(1,rms));

    }

    @Test
    public void getUserRecommendedMovies() throws Exception {
        List<UserRecommendedMovies> rms = userRecommendedMoviesDao.getUserRecommendedMovies(2);
        for(UserRecommendedMovies rm : rms)
            System.out.println(rm.getRmid() + " , " + rm.getRmv());
    }

    @Test
    public void clearUserRecommendedMovies() throws Exception {

        System.out.println(userRecommendedMoviesDao.clearUserRecommendedMovies(2));

    }

}