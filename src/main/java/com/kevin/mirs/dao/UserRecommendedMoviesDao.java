package com.kevin.mirs.dao;

import com.kevin.mirs.entity.UserRecommendedMovies;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecommendedMoviesDao {

    int addUserRecommendedMovies(@Param("uid") int uid,
                                 @Param("rmid") int rmid,
                                 @Param("rmv") float rmv);

    boolean clearUserRecommendedMovies();

}
