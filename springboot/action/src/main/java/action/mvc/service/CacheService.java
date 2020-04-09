package action.mvc.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * 封装本地缓存操作类
 */
@Component
public class CacheService {

    private Cache<String,Object> commonCache = null;

    @PostConstruct
    public void init(){
        commonCache = CacheBuilder.newBuilder()
                // 设置缓存容器的初始容量为10
                .initialCapacity(10)
                // 设置缓存中最大可以存储100个key，操过100之后会按照LRU的策略移除缓存项
                .maximumSize(100)
                // 设置写缓存后多少秒过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();
    }

    public void setCommonCache(String key,Object value){
        commonCache.put(key,value);
    }

    public Object getCommonCache(String key){
        return commonCache.getIfPresent(key);
    }
}
