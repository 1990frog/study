package com.customer.controller;

import com.customer.feignclient.ProductorFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    private ProductorFeignClient productor;

    @GetMapping("/customer")
    @ResponseBody
    public String customer(){
        return "success";
    }

    @GetMapping("/customer/feign")
    @ResponseBody
    public String clientProductor(){
        return productor.queryProduct();
    }
}
