package com.kevin.mirs.service;


import com.kevin.mirs.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserDao userDao;


    /**
     * 注册时添加一条用户信息
     * @param username 用户名
     * @param password 用户提交的密码
     * @param email 用户邮箱
     * @param verification 验证码
     * @return
     */
    public int addUer(String username, String password, String email, String verification) {

        return 0;
    }


    /**
     * 登录时通过用户名检查用户密码
     * @param username 用户名
     * @param password 用户提交的密码
     * @return
     */
    public int checkPasswordByUsername(String username, String password) {

        return 0;
    }


    /**
     * 登录时通过用户邮箱检查用户密码
     * @param email 用户邮箱
     * @param password 用户提交的密码
     * @return
     */
    public int checkPasswordByUserEmail(String email, String password) {

        return 0;
    }


    /**
     * 检查用户名是否被注册
     * @param username 用户名
     * @return 0：未注册，1：已注册
     */
    public int checkUsernameRegistered(String username) {
        int registered = 1;

        try {
            registered = userDao.checkUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("检查用户是否可用时发生异常" + e);
        }
        return registered;
    }


    /**
     * 检查用户邮箱是否可用
     * @param email 用户名
     * @return 0：未注册，1：已注册
     */
    public int checkEmailRegistered(String email) {
        int registered = 1;

        try {
            registered = userDao.checkUserEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("检查用户是否可用时发生异常" + e);
        }
        return registered;
    }



}
