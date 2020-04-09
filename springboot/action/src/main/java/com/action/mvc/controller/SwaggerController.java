package com.action.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.action.mvc.domain.param.SwaggerParam;
import com.action.mvc.domain.response.SwaggerResponse;

@Api("Swagger模型")
@RestController
public class SwaggerController {

    @ApiOperation("查询")
    @RequestMapping(value = "swagger",method = RequestMethod.GET)
    public SwaggerResponse search(@ApiParam SwaggerParam param){
        return SwaggerResponse.builder().build();
    }

    @ApiOperation("删除")
    @RequestMapping(value = "swagger",method = RequestMethod.DELETE)
    public SwaggerResponse delete(@ApiParam SwaggerParam param){
        return SwaggerResponse.builder().build();
    }

    @ApiOperation("修改")
    @RequestMapping(value = "swagger",method = RequestMethod.POST)
    public SwaggerResponse update(@ApiParam SwaggerParam param){
        return SwaggerResponse.builder().build();
    }
}
