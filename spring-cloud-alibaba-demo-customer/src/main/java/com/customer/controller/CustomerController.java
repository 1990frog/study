package com.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class CustomerController {

//    @NacosInjected
//    private ConfigService configService;

    @GetMapping("/customer")
    @ResponseBody
    public String customer(){
//        log.info(configService.getServerStatus());
//        return configService.getServerStatus();
        return "success";
    }
}
