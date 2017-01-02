package com.kevin.mirs.service;

import com.kevin.mirs.dao.UserRecommendedFriendsDao;
import com.kevin.mirs.dao.UserRecommendedMoviesDao;
import com.kevin.mirs.entity.UserRecommendedMovies;
import com.kevin.mirs.recommendation.RecommendFriends;
import com.kevin.mirs.recommendation.RecommendFriendsBySimilarity;
import com.kevin.mirs.recommendation.RecommendMovies;
import com.kevin.mirs.recommendation.RecommendMoviesByPerson;
import java.util.List;


import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RecommendService{
    @Resource
    UserRecommendedMoviesDao rm;

    @Resource
    UserRecommendedFriendsDao rf;

    @Resource
    MySQLJDBCDataModel data;


    public List<RecommendedItem> getRealTimeRecommendedMovies(int uid){
        RecommendMovies recommendMovies = new RecommendMoviesByPerson(data, 20);
        rm.clearUserRecommendedMovies(uid);
        rm.addUserRecommendedMovies(uid, recommendMovies.recommendMovies(uid,2));
        return recommendMovies.recommendMovies(uid,2);
    }

    public int addRecommendedMovies(int uid){
        List<RecommendedItem> recommendedMovies = getRealTimeRecommendedMovies(uid);
        rm.clearUserRecommendedMovies(uid);
        return rm.addUserRecommendedMovies(uid, recommendedMovies);
    }

    public List<UserRecommendedMovies> getRecommendedMoviesFromDB(int uid){
        return rm.getUserRecommendedMovies(uid);
    }

    public long[] getRealTimeRecommendedFriends(int uid){
        RecommendFriends recommendFriends = new RecommendFriendsBySimilarity(data);
        rf.clearUserRecommendedFriends(uid);
        rf.addUserRecommendedFriends(uid, recommendFriends.recommendFriends(uid, 10));
        return recommendFriends.recommendFriends(uid, 10);
    }

    public int addRecommendedFriends(int uid){
        long[] recommendedFriends = getRealTimeRecommendedFriends(uid);
        rf.clearUserRecommendedFriends(uid);
        return rf.addUserRecommendedFriends(uid, recommendedFriends);
    }

    public Integer[] getRecommendedFriendsFromDB(int uid){
        return rf.getUserRecommendedFriends(uid);
    }
}
