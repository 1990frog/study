package com.action.controller;

import com.action.domain.entity.Product;
import com.action.except.BusinessException;
import com.action.service.HelloSpringbootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class HelloSpringbootController {

    @Autowired
    private HelloSpringbootService helloSpringbootService;

    @GetMapping("/test")
    @ResponseBody
    public String demo(){
//        log.info("info");
//        log.warn("warn");
//        log.error("error");
//        MDC.put("KEY","VALUE");
        throw new BusinessException("haha");
//        return "hello logback";
    }

    @GetMapping("/query")
    @ResponseBody
    public Product query(){
        return helloSpringbootService.query();
    }

    @GetMapping("/queryall")
    @ResponseBody
    public List<Product> queryAll(){
        return helloSpringbootService.queryAll();
    }

    @PostMapping("/insert")
    @ResponseBody
    public void insert(@RequestBody Product product){
        helloSpringbootService.insert(product);
    }
}
