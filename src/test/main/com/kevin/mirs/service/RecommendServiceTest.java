package com.kevin.mirs.service;

import com.kevin.mirs.entity.UserRecommendedMovies;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:junit/spring-test.xml"})
public class RecommendServiceTest {
    @Resource
    RecommendService recommendService;

    @Test
    public void getRealTimeRecommendedMovies() throws Exception {
        List<RecommendedItem> recommendedItemList = recommendService.getRealTimeRecommendedMovies(2);
        for(RecommendedItem rmitem : recommendedItemList)
            System.out.println(rmitem);
    }

    @Test
    public void addRecommendedMovies() throws Exception {
        System.out.println(recommendService.addRecommendedMovies(2));

    }

    @Test
    public void getRecommendedMoviesFromDB() throws Exception {
        List<UserRecommendedMovies> rms = recommendService.getRecommendedMoviesFromDB(2);
        for(UserRecommendedMovies rm : rms)
            System.out.println(rm.getRmid() + " , " + rm.getRmv());
    }

    @Test
    public void getRecommendedFriends() throws Exception {
        long[] friends = recommendService.getRealTimeRecommendedFriends(2);
        for(long friend : friends)
            System.out.println(friend);
    }

    @Test
    public void addRecommendedFriends() throws Exception {
        System.out.println(recommendService.addRecommendedFriends(2));
    }

    @Test
    public void getRecommendedFriendsFromDB() throws Exception {
        Integer[] friends = recommendService.getRecommendedFriendsFromDB(1);
        for(Integer friend : friends)
            System.out.println(friend);
    }

}