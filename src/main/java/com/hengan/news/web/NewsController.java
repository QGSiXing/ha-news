package com.hengan.news.web;
import com.hengan.news.core.Result;
import com.hengan.news.core.ResultGenerator;
import com.hengan.news.dao.NewsMapper;
import com.hengan.news.model.po.News;
import com.hengan.news.model.vo.NewsVO;
import com.hengan.news.service.NewsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by cyq on 2019/02/12.
*/
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;
    @Resource
    private NewsMapper newsMapper;

//    @PostMapping("/add")
//    public Result add(News news) {
//        newsService.save(news);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        newsService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }

//    @PostMapping("/update")
//    public Result update(News news) {
//        newsService.update(news);
//        return ResultGenerator.genSuccessResult();
//    }

    @ApiOperation(value="获取新闻详情", notes="获取新闻详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Result detail(@PathVariable(name="id") Long id) {
        NewsVO news = newsService.detail(id);
        return ResultGenerator.genSuccessResult(news);
    }

    @ApiOperation(value="获取新闻列表信息", notes="获取新闻列表信息")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Result list(@RequestBody(required = false) NewsVO newsVO) {
//        PageHelper.startPage(1, 10);
        List<News> news = newsMapper.selectPage1(newsVO);
        PageInfo pageInfo = new PageInfo(news);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
