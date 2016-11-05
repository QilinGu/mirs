package com.kevin.mirs.web;

import com.kevin.mirs.dto.MIRSResult;
import com.kevin.mirs.service.SearchService;
import com.kevin.mirs.vo.Suggestion;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
@Api(value = "/search", description = "搜索相关的接口")
public class SearchController {

    @Resource
    SearchService searchService;

    @ResponseBody
    @RequestMapping(value = "/movie/{keyword}", method = RequestMethod.POST)
    @ApiOperation(value = "/movie/{keyword}", notes = "通过关键字搜索电影")
    public List<Suggestion> searchMovie(@PathVariable(value = "keyword") String keyword) {
        return searchService.searchMovie(keyword);
    }

}
