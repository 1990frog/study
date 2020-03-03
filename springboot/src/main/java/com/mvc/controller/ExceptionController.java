package com.mvc.controller;

import com.common.BusinessError;
import com.common.BusinessErrorEnum;
import com.common.Result;
import com.mvc.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    @GetMapping("/exception")
    @ResponseBody
    public Result exception() throws Exception {
        throw new Exception();
    }

    @GetMapping("/eception/business")
    @ResponseBody
    public Result businessException(){
        Result result;
        try {
            exceptionService.businessException();
            result = Result.builder("");
        }catch (Exception e){
            result = Result.builder(new BusinessError(BusinessErrorEnum.LOGIN_ERROR), "fail");
        }
        return result;
    }

    @GetMapping("/exception/runtime")
    @ResponseBody
    public Result throwRunTimeException(){
        throw new RuntimeException();
    }
}
