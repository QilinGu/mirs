package com.kevin.mirs.dao;


import com.kevin.mirs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 添加注册用户
     * @param user 用户实体
     * @return 影响的数目，1：添加成功，0：用户名/邮箱已存在
     */
    int addUser(@Param("user") User user);


    /**
     * 通过用户ID更新用户名
     * @param username 用户名
     * @param id 用户ID
     * @return 更新的数目，1：更新成功，0：更新失败
     */
    int updateUsernameByUserId(@Param("username") String  username, @Param("id") int id);
}
