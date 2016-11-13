package com.kevin.mirs.recommendation;

import com.kevin.mirs.dao.UserRecommendedFriendsDao;
import com.kevin.mirs.dao.UserRecommendedMoviesDao;
import com.kevin.mirs.entity.UserRecommendedFriends;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;


public class RecommendtionController {

    @Resource
    UserRecommendedMoviesDao urmv;
    UserRecommendedFriendsDao urfd;

    public static void main(String[] args){
        try{
            DataModel model = new FileDataModel(new File("src/main/resources/recommendation/test.csv"));
            RecommendFriends recommendFriends = new RecommendFriendsBySimilarity(model);
            RecommendMovies recommendMovies = new RecommendMoviesByPerson(model, 20);
            long[] friends = recommendFriends.recommendFriends(1, 3);
            List<RecommendedItem> recommendedItemList = recommendMovies.recommendMovies(1,2);
            for(long friend : friends) {

            }
            for(RecommendedItem recommendedItem : recommendedItemList) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
