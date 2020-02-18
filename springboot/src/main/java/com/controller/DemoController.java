package com.controller;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private TestService testService;

//    @Autowired
//    private WeatherService weatherService;

//    @RequestMapping("/hello/{id}")
//    @ResponseBody
//    public String hello(@PathVariable(value = "id") Long id) {
//        return Optional.ofNullable(demoService.getDemoById(id)).map(Demo::toString).orElse("empty String");
//    }

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return testService.test();
    }

//    @RequestMapping("weather")
//    @ResponseBody
//    public String weather() {
//        return weatherService.getType() + "," + weatherService.getRate();
//    }

}
