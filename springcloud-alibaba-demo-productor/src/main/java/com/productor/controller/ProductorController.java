package com.productor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ProductorController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/productor")
    @ResponseBody
    String queryProduct(){
        log.info("here");
        return "productor client";
    }
}
