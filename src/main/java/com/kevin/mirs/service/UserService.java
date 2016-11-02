package com.kevin.mirs.service;


import com.kevin.mirs.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

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



}
