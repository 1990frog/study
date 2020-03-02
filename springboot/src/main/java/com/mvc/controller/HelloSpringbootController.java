package com.mvc.controller;


import com.except.BusinessException;
import com.mvc.service.HelloSpringbootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
