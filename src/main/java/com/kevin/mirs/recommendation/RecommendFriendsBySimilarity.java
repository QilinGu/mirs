package com.kevin.mirs.recommendation;

import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * Created by 昊 on 2016/11/5.
 */
public class RecommendFriendsBySimilarity implements RecommendFriends{
    private DataModel model;
    private UserSimilarity similarity;
    private UserNeighborhood neighborhood;
    RecommendFriendsBySimilarity(DataModel model){
        this.model = model;
        try {
            similarity = new PearsonCorrelationSimilarity(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long[] recommendFriends(long uid, int frdnum){
        long[] neighbors = new long[frdnum];
        try {
            neighborhood = new NearestNUserNeighborhood(frdnum, similarity, model);
            neighbors = neighborhood.getUserNeighborhood(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return neighbors;
    }
}
