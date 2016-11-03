package com.kevin.mirs.dao;

import com.kevin.mirs.entity.Friend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FriendDao {

    /**
     * 添加一条朋友记录的信息
     * @param uid 用户ID
     * @param ufid 用户好友ID
     * @return 1：添加成功; 0：添加失败
     */
     int addFriendRecord(@Param("uid") int uid, @Param("ufid") int ufid);



    ArrayList<Friend> getAllFriend();


}
