package com.productor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductorController {

    @GetMapping("/productor")
    @ResponseBody
    String queryProduct(){
        return "productor client";
    }
}
