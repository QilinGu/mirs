package com.kevin.mirs.web;

import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.entity.Movie;
import com.kevin.mirs.service.MovieService;
import com.kevin.mirs.vo.SimpleMovie;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/movies")
@Api(value = "/movies", description = "电影相关的接口")
public class MovieController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    MovieService movieService;


    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "/{id}", notes = "通过电影的ID查询电影信息")
    public MIRSResult<Movie> getMovieByMovieId(@PathVariable(value = "id") int id) {
        logger.info("--------------------GET:/movies/" + id + "--------------------");

        Movie movie = movieService.getMovieByMovieId(id);

        if(movie != null) {
            return new MIRSResult<Movie>(true, movie);
        } else {
            return new MIRSResult<Movie>(false, "系统无此电影！");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/today", method = RequestMethod.GET)
    @ApiOperation(value = "/today", notes = "获得每日的首页电影推荐")
    public MIRSResult<ArrayList<SimpleMovie>> getTodayMovies() {
        logger.info("--------------------GET:/movies/today--------------------");

        ArrayList<SimpleMovie> simpleMovies = movieService.getTodayMovies();

        if(simpleMovies != null) {
            return new MIRSResult<ArrayList<SimpleMovie>>(true, simpleMovies);
        } else {
            return new MIRSResult<ArrayList<SimpleMovie>>(false, "获取每日电影时发生错误！");
        }

    }


}
