package com.kevin.mirs.dao;


import com.kevin.mirs.entity.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MovieDao {

    /**
     * 获取所有电影信息
     * @param orderBy 排序方式
     * @param limit 限制条数
     * @param offset 偏移量
     * @return 电影信息列表,没有则返回[]
     */
    ArrayList<Movie> getAllMovie(@Param("orderBy") String orderBy,
                                 @Param("limit") int limit,
                                 @Param("offset") int offset);


    /**
     * 通过电影的ID获取电影的基本信息
     * @param id 电影ID
     * @return 电影实体,没有则返回null
     */
    Movie getMovieById(@Param("id") int id);


    /**
     * 通过豆瓣电影ID获取电影的基本信息
     * @param doubanId 豆瓣电影ID
     * @return 电影实体,没有则返回null
     */
    Movie getMovieByDoubanId(@Param("doubanId") String doubanId);


    /**
     * 通过电影名精确获取电影信息
     * @param movieName 电影名
     * @return 电影实体,没有则返回null
     */
    Movie getMovieByMovieName(@Param("movieName") String movieName);


    /**
     * 根据电影名模糊查询可能的电影
     * @param movieName 电影名或其中一部分
     * @param orderBy 排序方式
     * @param limit 限制条数
     * @param offset 偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeMovieName(@Param("movieName") String movieName,
                                               @Param("orderBy") String orderBy,
                                               @Param("limit") int limit,
                                               @Param("offset") int offset);


    /**
     * 根据电影评分区间查找电影
     * @param low 最低分
     * @param high 最高分
     * @param orderBy 排序方式
     * @param limit 限制条数
     * @param offset 偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesByDoubanRating(@Param("low") float low,
                                             @Param("high") float high,
                                             @Param("orderBy") String orderBy,
                                             @Param("limit") int limit,
                                             @Param("offset") int offset);

}
