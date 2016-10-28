package com.kevin.mirs.dao;


import com.kevin.mirs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    int addUser(@Param("user") User user);

}
