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
     * @param id 用户ID
     * @param username 新用户名
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUsernameByUserId(@Param("id") int id, @Param("username") String username);


    /**
     * 通过用户ID更新用户密码
     * @param id 用户ID
     * @param password 新密码
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserPasswordByUserId(@Param("id") int id, @Param("password") String password);


    /**
     * 通过用户ID更新用户加密盐值
     * @param id 用户ID
     * @param salt 新密码
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserSaltByUserId(@Param("id") int id, @Param("salt") String salt);


     /**
     * 通过用户ID更新用户头像地址，似乎没用
     * @param id 用户ID
     * @param avatar 头像地址
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserAvatarByUserId(@Param("id") int id, @Param("avatar") String avatar);


    /**
     * 通过用户ID更新用户邮箱
     * @param id 用户ID
     * @param email 新邮箱
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserEmailByUserId(@Param("id") int id, @Param("email") String email);


    /**
     * 通过用户ID更新用户格言
     * @param id 用户ID
     * @param bio 新格言
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserBioByUserId(@Param("id") int id, @Param("bio") String bio);


    /**
     * 通过用户ID更新用户地址
     * @param id 用户ID
     * @param location 新地址
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserLocationByUserId(@Param("id") int id, @Param("location") String location);


    /**
     * 通过用户ID更新用户大学学校信息
     * @param id 用户ID
     * @param university 新学校
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserUniversityByUserId(@Param("id") int id, @Param("university") String university);


    /**
     * 通过用户ID更新用户专业信息
     * @param id 用户ID
     * @param major 新专业
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserMajorByUserId(@Param("id") int id, @Param("major") String major);


    /**
     * 通过用户ID更新上次登录信息
     * @param id 用户ID
     * @param time 登录时间
     * @param ip 登录IP
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUserLoginInfoByUserId(@Param("id") int id, @Param("time") Timestamp time, @Param("ip") String ip);


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


    /**
     * 通过用户ID得到用户密码和盐
     * @param id 用户id
     * @return User
     */
    User getUserPasswordByUserId(@Param("id") int id);


}
