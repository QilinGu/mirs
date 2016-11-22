package com.kevin.mirs.dao;

import com.kevin.mirs.enums.RegisterSessionEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RegisterSessionDaoTest {

    @Resource
    RegisterSessionDao registerSessionDao;

    @Test
    public void addRegisterSession() throws Exception {

        String email = "22@qq.com";
        String ip = "12.12.12.12";
        Timestamp ct = new Timestamp(new Date().getTime());
        Timestamp et = new Timestamp(new Date().getTime() + 30 * 60 * 1000);

        System.out.println(registerSessionDao.add(ct, email, ip, et));
    }

    @Test
    public void updateStatusByEmail() throws Exception {
        System.out.println(registerSessionDao.updateStatusByEmail(
                "22@qq.com",
                RegisterSessionEnum.REG_EXPIRED.getStatus()));
    }

    @Test
    public void getExpireTimeByEmail() throws Exception {
        System.out.println(
                registerSessionDao.getExpireTimeByEmail("22@qq.com")
        );
    }

    @Test
    public void getExpireTimeByStatus() throws Exception {
        System.out.println(
                registerSessionDao.getExpireTimeByStatus('1',"expire_time",1,2)
        );
    }

    @Test
    public void updateStatusByExpireTime() throws Exception {
        Timestamp t = registerSessionDao.getExpireTimeByEmail("22@qq.com");
        System.out.println(registerSessionDao.updateStatusByExpireTime(t, '3'));
    }


}