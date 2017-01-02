package com.kevin.mirs.dao;

import com.kevin.mirs.entity.User;
import com.kevin.mirs.utils.EncryptionUtils;
import com.kevin.mirs.vo.UserProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


/**
 * 配置Spring和Junit整合，使得Junit启动时加载SpingIoC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserDao userDao;

    @Test
    public void addUser() throws Exception {

        String username = "test343";
        String password = EncryptionUtils.getSalt(64);
        String salt = EncryptionUtils.getSalt(32);
        String email = "123434@qq.com";
        Timestamp registerTime = new Timestamp(new Date().getTime());
        String registerIp = "123.25.63.7";

        User user = new User(username, password, salt, email, registerTime, registerIp);

        logger.info("--------create a user: " + user);

        logger.info("-------before insert user id: " + user.getId());

        int result = userDao.addUser(user);

        logger.info("-------insert " + result + " user" );
        logger.info("-------after insert user id: " + user.getId());



    }

    @Test
    public void testTimestamp() throws Exception {

        Timestamp t1 = new Timestamp(new Date().getTime());
        Thread.sleep(1);
        Timestamp t2 = new Timestamp(new Date().getTime());

        if(t1.getTime() < t2.getTime()) {
            System.out.println(t1.getTime() + "\n" + t2.getTime());
        }
    }

    @Test
    public void update() throws Exception {
        System.out.println(userDao.updateUsernameByUserId(1, "newte23st"));
        System.out.println(userDao.updateUserPasswordByUserId(1, "newtest"));
        System.out.println(userDao.updateUserAvatarByUserId(1, "/src/1.jpeg"));
        System.out.println(userDao.updateUserBioByUserId(1, "2333333"));
        System.out.println(userDao.updateUserLocationByUserId(1, "成都"));
        System.out.println(userDao.updateUserUniversityByUserId(1, "电子科技大学"));
        System.out.println(userDao.updateUserMajorByUserId(1, "软件技术"));
        System.out.println(userDao.updateUserLoginInfoByUserId(1, new Timestamp(new Date().getTime()), "1.1.1.1"));
    }

    @Test
    public void check() throws Exception {
        System.out.println(userDao.checkUserEmail(""));
        System.out.println(userDao.checkUserEmail("123@qq.com"));
        System.out.println(userDao.checkUsername(""));
        System.out.println(userDao.checkUsername("#$%564354*(^%"));

    }

    @Test
    public void get() throws Exception {
        System.out.println(userDao.getUserByUserEmail("123@qq.com"));
        User user = userDao.getUserByUserEmail("123@qq.com");
        System.out.println(user.getStatus());
        System.out.println(user.getAvatar() == null);
//        System.out.println(userDao.getUserByUserEmail("123@qq.com"));
//        System.out.println(userDao.getUserByUsername(""));
//        System.out.println(userDao.getUserByUsername("newte23st"));
    }

    @Test
    public void getUserProfileByUserId() throws Exception {
        System.out.println(userDao.getUserProfileByUserId(63));
    }

    @Test
    public void updateUserProfile () throws Exception {
        UserProfile userProfile = new UserProfile(63, "123", "1@qq.com", "", "", "", "");
        System.out.println(userDao.updateUserProfile(userProfile));
    }

    @Test
    public void getUserPasswordByUserId() throws Exception {
        System.out.println(userDao.getUserPasswordByUserId(63));
    }

}