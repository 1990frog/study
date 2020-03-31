package com.action.guava.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@Controller
public class CacheableController {

    @RequestMapping(value = "/springcache",method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = "decode",key = "#param.key")
    public String getDecode(@Valid @RequestBody Param param){
        //如果redis内存在数据，那么下面的代码不会执行
        String value = UUID.randomUUID().toString();
        log.info("随机生成value = {}",value);
        return value;
    }

    @RequestMapping(value = "/springcache",method = RequestMethod.POST)
    @ResponseBody
    @CachePut(value = "decode", key = "#param.key")
    public String putDecode(@RequestBody Param param) {
        String value = UUID.randomUUID().toString();
        log.info("随机生成value = {}",value);
        return value;
    }

}
