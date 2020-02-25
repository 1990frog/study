package com.mvc.controller;

import com.mvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 验证三种初始化器
     * @param key Initializer key
     * @return Initializer value
     */
    @RequestMapping("initializer/{key}")
    @ResponseBody
    public String initializerTest(@PathVariable(value = "key") String key) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        return demoService.initializerTest(key);
    }


}
