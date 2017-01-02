package com.kevin.mirs.recommendation;


import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.*;

public class RecommendtionController {

    public static void main(String[] args){
        try{
//            MysqlDataSource dataSource = new MysqlDataSource();
//            dataSource.setServerName("localhost");
//            dataSource.setUser("root");
//            dataSource.setPassword("12345678");
//            dataSource.setDatabaseName("mirs");
//            JDBCDataModel model = new MySQLJDBCDataModel(dataSource, "mirs_user_movie", "uid", "mid", "score", null);
            DataModel model = new FileDataModel(new File("E:/AppServ/www/mirs/target/classes/recommendation/test.csv"));
            RecommendFriends recommendFriends = new RecommendFriendsBySimilarity(model);
            RecommendMovies recommendMovies = new RecommendMoviesByPerson(model, 20);
            long[] friends = recommendFriends.recommendFriends(1, 3);
            //List<RecommendedItem> recommendedItemList = recommendMovies.recommendMovies(1,2);
            //urmv.clearUserRecommendedMovies();
            //urfd.clearUserRecommendedFriends();
            //System.out.println(urmv.addUserRecommendedMovies(1,recommendedItemList));
            //System.out.println(urfd.addUserRecommendedFriends(1,friends));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
