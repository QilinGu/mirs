package com.kevin.mirs.service;


import com.kevin.mirs.dao.UserDao;
import com.kevin.mirs.entity.User;
import com.kevin.mirs.utils.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

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
     * @param ip 用户IP
     * @return User实例:成功；null：失败
     */
    public User addUer(String username, String password, String email, String verification, String ip) {

        // TODO 验证验证码

        String salt = EncryptionUtils.getSalt(128);
        password = EncryptionUtils.SHA512Encode(password, salt);
        Timestamp registerTime = new Timestamp(new Date().getTime());

        User user = new User(username, password, salt, email, registerTime, ip);

        try {
            if (userDao.addUser(user) == 1) {
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("注册时发生异常" + e);
        }

        return null;
    }


    /**
     * 登录时通过用户名检查用户密码
     * @param username 用户名
     * @param password 用户提交的密码
     * @return 1:成功；0:失败
     */
    public int checkPasswordByUsername(String username, String password) {

        try {
            User user = userDao.getUserByUsername(username);

            password = EncryptionUtils.SHA512Encode(password, user.getSalt());
            if (password.equals(user.getPassword())) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("通过用户名验证密码时发生错误" + e);
        }

        return 0;
    }


    /**
     * 登录时通过用户邮箱检查用户密码
     * @param email 用户邮箱
     * @param password 用户提交的密码
     * @return
     */
    public int checkPasswordByUserEmail(String email, String password) {

        try {
            User user = userDao.getUserByUserEmail(email);

            password = EncryptionUtils.SHA512Encode(password, user.getSalt());
            if (password.equals(user.getPassword())) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("通过邮箱验证密码时发生错误" + e);
        }

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
