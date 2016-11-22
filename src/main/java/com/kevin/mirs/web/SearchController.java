package com.kevin.mirs.web;

import com.kevin.mirs.service.SearchService;
import com.kevin.mirs.vo.SuggestionMovie;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/searches")
@Api(value = "/searches", description = "搜索相关的接口")
public class SearchController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    SearchService searchService;

    @ResponseBody
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ApiOperation(value = "/movies", notes = "通过关键字搜索电影")
    public List<SuggestionMovie> searchMovie(@RequestParam(value = "keyword") String keyword,
                                             @RequestParam(value = "limit", required = false, defaultValue = "6") int limit) {
        logger.info("--------------------GET:/searches/movies--------------------");
        logger.info("--------------------keyword:" + keyword + ";limit:" + limit + "--------------------");

        return searchService.searchMovie(keyword, limit);
    }

}
