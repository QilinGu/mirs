package com.kevin.mirs.recommendation;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.io.*;
import java.util.List;

/**
 * Created by 昊 on 2016/11/5.
 */
public class RecommendtionController {
    public static void main(String[] args){
        try{
            DataModel model = new FileDataModel(new File("src/main/resources/recommendation/test.csv"));
            RecommendFriends recommendFriends = new RecommendFriendsBySimilarity(model);
            RecommendMovies recommendMovies = new RecommendMoviesByPerson(model, 20);
            long[] friends = recommendFriends.recommendFriends(1, 3);
            List<RecommendedItem> recommendedItemList = recommendMovies.recommendMovies(1,2);
            //System.out.println("Recommend Friends:");
            RandomAccessFile friendsFile, moviesFile;
            friendsFile = new RandomAccessFile("target/mirs/resources/recommendation/friends/" + 1 + ".csv", "rw");
            for(long friend : friends) {
                friendsFile.writeChars(String.valueOf(friend));
                friendsFile.write('\n');
            }
            //System.out.println("Recommend Movies");
            moviesFile = new RandomAccessFile("target/mirs/resources/recommendation/movies/" + 1 + ".csv", "rw");
            for(RecommendedItem recommendedItem : recommendedItemList) {
                moviesFile.writeChars(String.valueOf(recommendedItem.getItemID()));
                moviesFile.write('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
