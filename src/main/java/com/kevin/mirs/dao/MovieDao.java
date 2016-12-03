package com.kevin.mirs.dao;


import com.kevin.mirs.entity.Movie;
import com.kevin.mirs.vo.SimpleMovie;
import com.kevin.mirs.vo.SuggestionMovie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface MovieDao {

    /**
     * 获取所有电影信息
     *
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表, 没有则返回[]
     */
    ArrayList<Movie> getMovies(@Param("orderBy") String orderBy,
                               @Param("limit") int limit,
                               @Param("offset") int offset);

    /**
     * 获取索引需要的电影信息
     *
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表, 没有则返回[]
     */
    ArrayList<Movie> getIndexMovies(@Param("orderBy") String orderBy,
                               @Param("limit") int limit,
                               @Param("offset") int offset);


    /**
     * 通过电影的ID获取电影的基本信息
     *
     * @param id 电影ID
     * @return 电影实体, 没有则返回null
     */
    Movie getMovieById(@Param("id") int id);


    /**
     * 通过豆瓣电影ID获取电影的基本信息
     *
     * @param doubanId 豆瓣电影ID
     * @return 电影实体, 没有则返回null
     */
    Movie getMovieByDoubanId(@Param("doubanId") String doubanId);


    /**
     * 通过电影名精确获取电影信息
     *
     * @param movieName 电影名
     * @return 电影实体, 没有则返回null
     */
    Movie getMovieByMovieName(@Param("movieName") String movieName);


    /**
     * 根据电影名模糊查询可能的电影
     *
     * @param movieName 电影名或其中一部分
     * @param orderBy   排序方式
     * @param limit     限制条数
     * @param offset    偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeMovieName(@Param("movieName") String movieName,
                                               @Param("orderBy") String orderBy,
                                               @Param("limit") int limit,
                                               @Param("offset") int offset);


    /**
     * 根据豆瓣电影评分区间查找电影
     *
     * @param low     最低分
     * @param high    最高分
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesByDoubanRating(@Param("low") String low,
                                             @Param("high") String high,
                                             @Param("orderBy") String orderBy,
                                             @Param("limit") int limit,
                                             @Param("offset") int offset);


    /**
     * 根据IMDb电影评分区间查找电影
     *
     * @param low     最低分
     * @param high    最高分
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesByIMDbRating(@Param("low") String low,
                                           @Param("high") String high,
                                           @Param("orderBy") String orderBy,
                                           @Param("limit") int limit,
                                           @Param("offset") int offset);


    /**
     * 获得某一年的电影
     *
     * @param year    年份
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesByReleaseYear(@Param("year") String year,
                                            @Param("orderBy") String orderBy,
                                            @Param("limit") int limit,
                                            @Param("offset") int offset);


    /**
     * 根据年份区间查找电影
     *
     * @param low     低年份
     * @param high    高年份
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesByReleaseYears(@Param("low") String low,
                                             @Param("high") String high,
                                             @Param("orderBy") String orderBy,
                                             @Param("limit") int limit,
                                             @Param("offset") int offset);


    /**
     * 根据电影时长区间查找电影
     *
     * @param low     低时长
     * @param high    高时长
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesByRuntime(@Param("low") String low,
                                        @Param("high") String high,
                                        @Param("orderBy") String orderBy,
                                        @Param("limit") int limit,
                                        @Param("offset") int offset);


    /**
     * 根据导演名称模糊查询可能的电影
     *
     * @param director 导演名称
     * @param orderBy  排序方式
     * @param limit    限制条数
     * @param offset   偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeDirector(@Param("director") String director,
                                              @Param("orderBy") String orderBy,
                                              @Param("limit") int limit,
                                              @Param("offset") int offset);


    /**
     * 根据编剧名称模糊查询可能的电影
     *
     * @param screenwriter 编剧名称
     * @param orderBy      排序方式
     * @param limit        限制条数
     * @param offset       偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeScreenwriter(@Param("screenwriter") String screenwriter,
                                                  @Param("orderBy") String orderBy,
                                                  @Param("limit") int limit,
                                                  @Param("offset") int offset);


    /**
     * 根据演员名称模糊查询可能的电影
     *
     * @param actor   演员名称
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeActor(@Param("actor") String actor,
                                           @Param("orderBy") String orderBy,
                                           @Param("limit") int limit,
                                           @Param("offset") int offset);


    /**
     * 根据电影类型模糊查询可能的电影
     *
     * @param type    电影类型
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeType(@Param("type") String type,
                                          @Param("orderBy") String orderBy,
                                          @Param("limit") int limit,
                                          @Param("offset") int offset);


    /**
     * 根据国家模糊查询可能的电影
     *
     * @param originPlace 国家
     * @param orderBy     排序方式
     * @param limit       限制条数
     * @param offset      偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeOriginPlace(@Param("originPlace") String originPlace,
                                                 @Param("orderBy") String orderBy,
                                                 @Param("limit") int limit,
                                                 @Param("offset") int offset);


    /**
     * 根据语言模糊查询可能的电影
     *
     * @param language 语言
     * @param orderBy  排序方式
     * @param limit    限制条数
     * @param offset   偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeLanguage(@Param("language") String language,
                                              @Param("orderBy") String orderBy,
                                              @Param("limit") int limit,
                                              @Param("offset") int offset);


    /**
     * 根据别名模糊查询可能的电影
     *
     * @param anotherName 别名
     * @param orderBy     排序方式
     * @param limit       限制条数
     * @param offset      偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeAnotherName(@Param("anotherName") String anotherName,
                                                 @Param("orderBy") String orderBy,
                                                 @Param("limit") int limit,
                                                 @Param("offset") int offset);


    /**
     * 根据获奖信息模糊查询可能的电影
     *
     * @param award   获奖信息
     * @param orderBy 排序方式
     * @param limit   限制条数
     * @param offset  偏移量
     * @return 电影信息列表，没有则返回[]
     */
    ArrayList<Movie> getMoviesIncludeAward(@Param("award") String award,
                                           @Param("orderBy") String orderBy,
                                           @Param("limit") int limit,
                                           @Param("offset") int offset);


    /**
     * 获得搜索时建议的电影信息
     * @param id 电影ID
     * @return 建议电影信息，没有则返回null
     */
    SuggestionMovie getSuggestedMovie(@Param("id") int id);


    /**
     * 随机获得几条简单电影的信息
     * @param limit
     * @return
     */
    ArrayList<SimpleMovie> getRandomSimpleMovies(@Param("limit") int limit);

}
