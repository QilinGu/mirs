package com.kevin.mirs.dao;


import com.kevin.mirs.entity.User;
import com.kevin.mirs.vo.UserProfile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface UserDao {

    /**
     * 添加注册用户
     * @param user 用户实体
     * @return 影响的数目，1：添加成功（同时设置user的id属性），0：用户名/邮箱已存在
     */
    int addUser(User user);


    /**
     * 通过用户ID更新用户名
     * @param username 新用户名
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUsernameByUserId(@Param("username") String  username, @Param("id") int id);


    /**
     * 通过用户ID更新用户密码
     * @param password 新密码
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserPasswordByUserId(@Param("password") String password, @Param("id") int id);


    /**
     * 通过用户ID更新用户加密盐值
     * @param salt 新密码
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserSaltByUserId(@Param("salt") String salt, @Param("id") int id);


     /**
     * 通过用户ID更新用户头像地址，似乎没用
     * @param avatar 头像地址
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserAvatarByUserId(@Param("avatar") String avatar, @Param("id") int id);


    /**
     * 通过用户ID更新用户邮箱
     * @param email 新邮箱
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserEmailByUserId(@Param("email") String email, @Param("id") int id);


    /**
     * 通过用户ID更新用户格言
     * @param bio 新格言
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserBioByUserId(@Param("bio") String bio, @Param("id") int id);


    /**
     * 通过用户ID更新用户地址
     * @param location 新地址
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserLocationByUserId(@Param("location") String location, @Param("id") int id);


    /**
     * 通过用户ID更新用户大学学校信息
     * @param university 新学校
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserUniversityByUserId(@Param("university") String university, @Param("id") int id);


    /**
     * 通过用户ID更新用户专业信息
     * @param major 新专业
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserMajorByUserId(@Param("major") String major, @Param("id") int id);


    /**
     * 通过用户ID更新上次登录信息
     * @param time 登录时间
     * @param ip 登录IP
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserLoginInfoByUserId(@Param("time") Timestamp time, @Param("ip") String ip, @Param("id") int id);


    /**
     * 根据用户名获得用户信息
     * @param username 用户名
     * @return 如果用户存在，返回用户实体，否则，返回NULL
     */
    User getUserByUsername(@Param("username") String  username);


    /**
     * 根据邮箱获得用户信息
     * @param email 邮箱
     * @return 如果用户存在，返回用户实体，否则，返回NULL
     */
    User getUserByUserEmail(@Param("email") String email);


    /**
     * 检查用户名是否被注册
     * @param username 用户名
     * @return 1：已被注册;0：未被注册
     */
    int checkUsername(@Param("username") String  username);


    /**
     * 检查邮箱是否被注册
     * @param email 邮箱
     * @return 1：已被注册;0：未被注册
     */
    int checkUserEmail(@Param("email") String  email);


    /**
     * 通过用户ID得到用户信息
     * @param id 用户id
     * @return 成功:UserProfile; 失败：null
     */
    UserProfile getUserProfileByUserId(@Param("id") int id);


    /**
     * 更新用户信息
     * @param userProfile 用户信息
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserProfile(UserProfile userProfile);


}
