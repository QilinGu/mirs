package com.kevin.mirs.dao;


import com.kevin.mirs.entity.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieDao {

    /**
     * 通过电影的ID获取电影的基本信息
     * @param id 电影ID
     * @return
     */
    Movie getMovieByMovieId(@Param("id") int id);



}
