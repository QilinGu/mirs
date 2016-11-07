package com.kevin.mirs.recommendation;

import com.kevin.mirs.dao.UserRecommendedFriendsDao;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;


public class RecommendtionController {

    @Resource
    UserRecommendedFriendsDao urfd;

    public static void main(String[] args){
        try{
            DataModel model = new FileDataModel(new File("src/main/resources/recommendation/test.csv"));
            RecommendFriends recommendFriends = new RecommendFriendsBySimilarity(model);
            RecommendMovies recommendMovies = new RecommendMoviesByPerson(model, 20);
            long[] friends = recommendFriends.recommendFriends(1, 3);
            List<RecommendedItem> recommendedItemList = recommendMovies.recommendMovies(1,2);
            /*RandomAccessFile friendsFile, moviesFile;
            friendsFile = new RandomAccessFile("target/mirs/resources/recommendation/friends/" + 1 + ".csv", "rw");
            for(long friend : friends) {
                friendsFile.writeChars(String.valueOf(friend));
                friendsFile.write('\n');
            }
            moviesFile = new RandomAccessFile("target/mirs/resources/recommendation/movies/" + 1 + ".csv", "rw");
            for(RecommendedItem recommendedItem : recommendedItemList) {
                moviesFile.writeChars(String.valueOf(recommendedItem.getItemID()));
                moviesFile.write('\n');
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
