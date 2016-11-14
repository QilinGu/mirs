package com.kevin.mirs.dao;

import com.google.common.collect.HashMultimap;
import com.kevin.mirs.entity.UserRecommendedFriends;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public interface UserRecommendedFriendsDao {

    int addUserRecommendedFriends(@Param("uid") int uid,
                                  @Param("rfids") long[] rfids);

    Integer[] getUserRecommendedFriends(@Param("uid") int uid);

    boolean clearUserRecommendedFriends(@Param("uid") int uid);
}
