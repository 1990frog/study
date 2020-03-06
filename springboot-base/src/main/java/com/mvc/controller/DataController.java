package com.mvc.controller;

import com.mvc.domain.entity.Product;
import com.mvc.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
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
    public Product mybatisCacheQuery(@PathParam("type")String type){
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

    @PostMapping("/insert")
    @ResponseBody
    public void insert(@RequestBody Product product){
        dataService.insert(product);
    }
}
