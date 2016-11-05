package com.kevin.mirs.recommendation;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * Created by 昊 on 2016/11/5.
 */
interface RecommendFriends {
    long[] recommendFriends(long uid, int frdnum);
}
