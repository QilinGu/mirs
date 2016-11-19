package com.kevin.mirs.recommendation;

import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 昊 on 2016/11/5.
 */
public class RecommendMoviesByPerson implements RecommendMovies{
    private DataModel model;
    private UserSimilarity similarity;
    private UserNeighborhood neighborhood;
    private Recommender recommender;
    public RecommendMoviesByPerson(DataModel model, int frdN){
        this.model = model;
        try {
            similarity = new PearsonCorrelationSimilarity(model);
            neighborhood = new NearestNUserNeighborhood(frdN, similarity, model);
            recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RecommendedItem> recommendMovies(int uid, int itemNum){
        List<RecommendedItem> recommendedItemList = new ArrayList<RecommendedItem>(itemNum);
        try {
            recommendedItemList = recommender.recommend(uid,itemNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommendedItemList;
    }
}
