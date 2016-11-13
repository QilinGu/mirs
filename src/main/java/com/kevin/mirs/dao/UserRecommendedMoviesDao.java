package com.kevin.mirs.dao;

import com.kevin.mirs.entity.UserRecommendedMovies;
import org.apache.ibatis.annotations.Param;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRecommendedMoviesDao {

    int addUserRecommendedMovies(@Param("uid") int uid,
                                 @Param("rms")List<RecommendedItem> rms);

    boolean clearUserRecommendedMovies();

}
