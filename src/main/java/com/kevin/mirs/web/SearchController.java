package com.kevin.mirs.web;

import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.service.SearchService;
import com.kevin.mirs.vo.SimpleMovie;
import com.kevin.mirs.vo.SuggestionMovie;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/searches")
@Api(value = "/searches", description = "搜索相关的接口")
public class SearchController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    SearchService searchService;

    @ResponseBody
    @RequestMapping(value = "/suggestions", method = RequestMethod.GET)
    @ApiOperation(value = "/suggestions", notes = "搜索电影时的提示信息")
    public List<SuggestionMovie> getSuggestions(@RequestParam(value = "keyword") String keyword,
                                             @RequestParam(value = "limit", required = false, defaultValue = "6") int limit) {
        logger.info("--------------------GET:/searches/suggestions--------------------");
        logger.info("--------------------keyword:" + keyword + ";limit:" + limit + "--------------------");

        return searchService.getSuggestionMovies(keyword, limit);
    }

    @ResponseBody
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ApiOperation(value = "/movies", notes = "搜索电影")
    public MIRSResult<ArrayList<SimpleMovie>> searchMoives(@RequestParam(value = "keywords") String keywords,
                                              @RequestParam(value = "type") int type,
                                              @RequestParam(value = "sort", required = false, defaultValue = "1") int sort,
                                              @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                              @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
        logger.info("--------------------GET:/searches/movies--------------------");

        ArrayList<SimpleMovie> results = searchService.searchMoives(keywords, type, sort, limit, offset);

        if (results != null) {
            return new MIRSResult<>(true, results);
        }

        return new MIRSResult<>(false, "出问题了哦~");
    }

}
