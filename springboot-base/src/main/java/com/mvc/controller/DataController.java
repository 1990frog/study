package com.mvc.controller;

import com.mvc.domain.entity.Product;
import com.mvc.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping("/query")
    @ResponseBody
    public Product query(){
        return dataService.query();
    }

    @GetMapping("/cache/query/{type}")
    @ResponseBody
    public Product mybatisCacheQuery(@PathVariable("type")String type){
        if("1".equals(type)){
            return dataService.mybatisCache1();
        }else if("2".equals(type)){
            return dataService.mybatisCache2();
        }else{
            return dataService.mybatisCache3();
        }

    }

    @GetMapping("/queryall")
    @ResponseBody
    public List<Product> queryAll(){
        return dataService.queryAll();
    }

    @GetMapping("/rowbounds/{pageid}")
    @ResponseBody
    public List<Product> queryAllWithRowBounds(@PathVariable("pageid")Integer pageid){
        return dataService.queryAllWithRowBounds(new RowBounds(pageid,20));
    }

    @GetMapping("/params/{pageid}")
    @ResponseBody
    public List<Product> queryAllWithParam(@PathVariable("pageid") Integer pageid){
        return dataService.queryAllWithParam(pageid,20);
    }

    @PostMapping("/insert")
    @ResponseBody
    public void insert(@RequestBody Product product){
        dataService.insert(product);
    }
}
