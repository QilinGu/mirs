package com.kevin.mirs.recommendation;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

/**
 * Created by 昊 on 2016/11/5.
 */
interface RecommendMovies {
    List<RecommendedItem> recommendMovies(int uid, int itemNum);
}
