package com.kevin.mirs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class UserRecommendedFriendsDaoTest {

    @Resource
    UserRecommendedFriendsDao userRecommendedFriendsDao;

    @Test
    public void addUserRecommendedFriends() throws Exception {
        long[] fids = {1,2,3};
        System.out.println(userRecommendedFriendsDao.addUserRecommendedFriends(1, fids));
    }

    @Test
    public void getUserRecommendedFriends() throws Exception {
        Integer[] friends = userRecommendedFriendsDao.getUserRecommendedFriends(1);
        for(Integer friend : friends)
            System.out.println(friend);
    }

    @Test
    public void clearUserRecommendedFriends() throws Exception {
        System.out.println(userRecommendedFriendsDao.clearUserRecommendedFriends(1));
    }

}