package com.kevin.mirs.recommendation;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.io.File;
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
            System.out.println("Recommend Friends:");
            for(long friend : friends) {
                System.out.println(friend);
            }
            System.out.println("Recommend Movies");
            for(RecommendedItem recommendedItem : recommendedItemList) {
                System.out.println(recommendedItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}