package com.kevin.mirs.dao;

import com.kevin.mirs.utils.EncryptionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class EmailVerifyDaoTest {

    @Resource
    EmailVerifyDao dao;

    @Test
    public void add() throws Exception {

        String e = "123@qq.com";
        Timestamp ct = new Timestamp(new Date().getTime());
        Timestamp et = new Timestamp(new Date().getTime() + 5000);
        char c = '1';
        String v = EncryptionUtils.getVerification();
        char vt = '1';
        String ip = "1.1.1.1";
        dao.add(e, ct, et, c, v, vt, ip);
    }

    @Test
    public void updateStatusByEmail() throws Exception {
        dao.updateStatusByEmail("123@qq.com", '2');
    }

    @Test
    public void updateStatusByExpireTime() throws Exception {

        dao.updateStatusByExpireTime(new Timestamp(new Date().getTime()), '3');
    }

    @Test
    public void getExpireTimeByEmail() throws Exception {
        System.out.println(dao.getExpireTimeByEmail("123@qq.com"));
    }

    @Test
    public void getExpireTimeByStatus() throws Exception {
        System.out.println(dao.getExpireTimeByStatus('1', "expire_time", 1, 0));
    }

}