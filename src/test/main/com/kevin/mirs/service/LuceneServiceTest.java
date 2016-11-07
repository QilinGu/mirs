package com.kevin.mirs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit Sping配置文件
@ContextConfiguration({"classpath:junit/spring-test.xml"})
public class LuceneServiceTest {
    @Resource
    LuceneService luceneService;

    @Test
    public void indexMovie() throws Exception {
        long starTime=System.currentTimeMillis();
        luceneService.indexMovie();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime - starTime);
    }


    @Test
    public void deleteAllIndexes() throws Exception {
        luceneService.deleteAllIndexes();
    }

}