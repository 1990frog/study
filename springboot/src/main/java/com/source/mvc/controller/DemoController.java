package com.source.mvc.controller;

import com.example.mystarter.MystarterServrice;
import com.source.mvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private MystarterServrice mystarterServrice;

    /**
     * 验证三种初始化器
     * @param key Initializer key
     * @return Initializer value
     */
    @GetMapping("/demo/initializer/{key}")
    @ResponseBody
    public String initializerTest(@PathVariable(value = "key") String key) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        return demoService.initializerTest(key);
    }

    @GetMapping("/demo")
    @ResponseBody
    public String demo(){
        return mystarterServrice.getAuthor();
    }


}
