package action.guava.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuavaCacheController {

    @Autowired
    private GuavaCache guavaCache;

    @GetMapping("/guavacache/set/{key}/{value}")
    @ResponseBody
    public String set(@PathVariable("key")String key, @PathVariable("value")String value){
        guavaCache.setCommonCache(key,value);
        return "success";
    }

    @GetMapping("/guavacache/get/{key}")
    @ResponseBody
    public String get(@PathVariable("key")String key){
        return (String)guavaCache.getFromCommonCache(key);
    }
}
