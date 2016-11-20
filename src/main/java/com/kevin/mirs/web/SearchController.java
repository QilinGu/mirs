package com.kevin.mirs.web;

import com.kevin.mirs.service.SearchService;
import com.kevin.mirs.vo.SuggestionMovie;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/searches")
@Api(value = "/searches", description = "搜索相关的接口")
public class SearchController {

    @Resource
    SearchService searchService;

    @ResponseBody
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ApiOperation(value = "/movies", notes = "通过关键字搜索电影")
    public List<SuggestionMovie> searchMovie(@RequestParam(value = "keyword") String keyword,
                                             @RequestParam(value = "limit", required = false, defaultValue = "6") int limit) {
        System.out.println("--------------用户输入了：" + keyword + "-------------");
        return searchService.searchMovie(keyword, limit);
    }

}
