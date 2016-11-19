package com.kevin.mirs.recommendation;

import com.kevin.mirs.dao.UserRecommendedFriendsDao;
import com.kevin.mirs.dao.UserRecommendedMoviesDao;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;


public class RecommendtionController {

    public static void main(String[] args){
        try{
            DataModel model = new FileDataModel(new File("src/main/resources/recommendation/test.csv"));
            RecommendFriends recommendFriends = new RecommendFriendsBySimilarity(model);
            RecommendMovies recommendMovies = new RecommendMoviesByPerson(model, 20);
            long[] friends = recommendFriends.recommendFriends(1, 3);
            List<RecommendedItem> recommendedItemList = recommendMovies.recommendMovies(1,2);
            //urmv.clearUserRecommendedMovies();
            //urfd.clearUserRecommendedFriends();
            //System.out.println(urmv.addUserRecommendedMovies(1,recommendedItemList));
            //System.out.println(urfd.addUserRecommendedFriends(1,friends));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
