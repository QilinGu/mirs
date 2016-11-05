package com.kevin.mirs.service;

import com.kevin.mirs.dao.MovieDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:junit/spring-test.xml"})
public class SearchServiceTest {

    @Resource
    SearchService searchService;

    @Test
    public void indexMovie() throws Exception {
        long starTime=System.currentTimeMillis();
        searchService.indexMovie();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime - starTime);
    }

    @Test
    public void searchMovie() throws Exception {
//        System.out.println(searchService.searchMovie("人妖"));
        System.out.println(searchService.searchMovie("链接"));
    }

    @Test
    public void deleteAllIndexes() throws Exception {
        searchService.deleteAllIndexes();
    }

}