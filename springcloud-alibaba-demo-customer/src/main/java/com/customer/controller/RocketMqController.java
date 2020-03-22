package com.customer.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RocketMqController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("rocketmq/customer")
    @ResponseBody
    public String test() {
        rocketMQTemplate.convertAndSend("topic","haha");
        return "";
    }


}
