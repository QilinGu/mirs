package com.kevin.mirs.dao;

import com.kevin.mirs.entity.UserRecommendedFriends;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRecommendedFriendsDao {

    int addUserRecommendedFriends(@Param("uid") int uid,
                                  @Param("rfid") int rfid);

    boolean clearUserRecommendedFriends();

    int addFriends(@Param("u") int u,
                   @Param("f") int f);
}
