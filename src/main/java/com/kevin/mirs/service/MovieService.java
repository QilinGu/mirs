package com.kevin.mirs.service;

import com.kevin.mirs.dao.MovieDao;
import com.kevin.mirs.entity.Movie;
import com.kevin.mirs.enums.MovieColumnEnum;
import com.kevin.mirs.vo.SimpleMovie;
import com.kevin.mirs.vo.SuggestionMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class MovieService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    MovieDao movieDao;


    public Movie getMovieByMovieId(int id) {
        Movie movie = null;
        try {
            movie = movieDao.getMovieById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    public ArrayList<SimpleMovie> getTodayMovies() {

        int limit = 6;
        ArrayList<SimpleMovie> suggestionMovies = null;

        try {
            suggestionMovies = movieDao.getRandomSimpleMovies(limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suggestionMovies;
    }

}
