package com.kevin.mirs.dao;

import com.kevin.mirs.entity.UserRecommendedFriends;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRecommendedFriendsDao {

    int addUserRecommendedFriends(@Param("uid") int uid,
                                  @Param("rfid") int rfid);

    ArrayList<UserRecommendedFriends>
}
