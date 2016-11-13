package com.kevin.mirs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class UserRecommendedFriendsDaoTest {

    @Resource
    UserRecommendedFriendsDao userRecommendedFriendsDao;

    @Test
    public void addUserRecommendedFriends() throws Exception {
        System.out.println(userRecommendedFriendsDao.addUserRecommendedFriends(1,1));
    }

    @Test
    public void clearUserRecommendedFriends() throws Exception {
        System.out.println(userRecommendedFriendsDao.clearUserRecommendedFriends());
    }

}