package com.kevin.mirs.service;


import com.kevin.mirs.dao.UserDao;
import com.kevin.mirs.entity.User;
import com.kevin.mirs.utils.EncryptionUtils;
import com.kevin.mirs.vo.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserService {

    // 过期时间
    public static final long EXPIRED_TIME = 30 * 60 * 1000;

    // 注册验证SESSION ID
    public static final String VERIFICATION = "VERIFICATION_SESSION";

    // 存储到SESSION中的用户ID
    public static final String USER_ID = "USER_ID";

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

        logger.info("--------------------addUser--------------------");


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
     * @return 用户ID:成功；0:失败
     */
    public int checkPasswordByUsername(String username, String password) {

        logger.info("--------------------checkPasswordByUsername--------------------");

        try {
            User user = userDao.getUserByUsername(username);
            if (user == null) {
                return 0;
            }

            password = EncryptionUtils.SHA512Encode(password, user.getSalt());
            if (password.equals(user.getPassword())) {
                return user.getId();
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
     * @return 用户ID:成功；0:失败
     */
    public int checkPasswordByUserEmail(String email, String password) {

        logger.info("--------------------checkPasswordByUserEmail--------------------");

        try {
            User user = userDao.getUserByUserEmail(email);
            if (user == null) {
                return 0;
            }

            password = EncryptionUtils.SHA512Encode(password, user.getSalt());
            if (password.equals(user.getPassword())) {
                return user.getId();
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

        logger.info("--------------------checkUsernameRegistered--------------------");

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

        logger.info("--------------------checkEmailRegistered--------------------");

        int registered = 1;

        try {
            registered = userDao.checkUserEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("检查用户是否可用时发生异常" + e);
        }
        return registered;
    }


    /**
     * 通过用户ID得到用户信息
     * @param id 用户id
     * @return 成功:UserProfile; 失败：null
     */
    public UserProfile getUserProfileByUserId(int id) {

        logger.info("--------------------getUserProfileByUserId--------------------");

        UserProfile userProfile = null;

        try {
            userProfile = userDao.getUserProfileByUserId(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取用户信息时发生异常" + e);
        }
        return userProfile;
    }


    /**
     * 更新用户信息
     * @param userProfile 用户信息
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    public int updateUserProfile(UserProfile userProfile) {

        logger.info("--------------------updateUserProfile--------------------");

        int status = 0;

        try {
            status = userDao.updateUserProfile(userProfile);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("获取用户信息时发生异常" + e);
        }

        return status;
    }

}
