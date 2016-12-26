package com.kevin.mirs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:junit/spring-test.xml"})
public class SearchServiceTest {

    @Resource
    SearchService searchService;

    @Test
    public void searchMovie() throws Exception {
//        System.out.println(searchService.getSuggestionMovies("人妖"));
        System.out.println(searchService.getSuggestionMovies("1", 1));
    }



}