package com.kevin.mirs.dao;

import com.kevin.mirs.entity.User;
import com.kevin.mirs.utils.Encryption;
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
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserDao userDao;

    @Test
    public void addUser() throws Exception {

        String username = "test";
        String password = Encryption.getSalt(64);
        String salt = Encryption.getSalt(32);
        String email = "123@qq.com";
        Timestamp registerTime = new Timestamp(new Date().getTime());
        String registerIp = "123.25.63.7";

        User user = new User(username, password, salt, email, registerTime, registerIp);

        logger.info("--------create a user: " + user);

        int result = userDao.addUser(user);

        logger.info("-------insert " + result + " user" );

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
    public void updateUsernameByUserId() throws Exception {
        int result = userDao.updateUsernameByUserId("newtest", 10);
        System.out.println(result);
    }

}