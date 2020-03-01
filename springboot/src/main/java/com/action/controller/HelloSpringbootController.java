package com.action.controller;

import com.action.except.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HelloSpringbootController {

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
}
