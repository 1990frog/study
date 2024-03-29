import com.google.common.cache.*;
import lombok.Data;

import java.util.concurrent.TimeUnit;

public class GuavaCacheDemo {

    @Data
    class Student {
        private Integer id;
        private String name;
    }

    private Cache cache = CacheBuilder.newBuilder()
            // 设置并发级别为8，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(8)
            // 设置写缓存后8秒钟过期
            .expireAfterWrite(8, TimeUnit.SECONDS)
            // 设置缓存容器的初始容量为10
            .initialCapacity(10)
            // 设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
            .maximumSize(100)
            // 设置要统计缓存的命中率
            .recordStats()
            // 设置缓存的移除通知
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(RemovalNotification<Object, Object> notification) {
                    System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                }
            })
            // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build(
                    new CacheLoader<Integer, Student>() {
                        @Override
                        public Student load(Integer key) throws Exception {
                            System.out.println("load student " + key);
                            Student student = new Student();
                            student.setId(key);
                            student.setName("name " + key);
                            return student;
                        }
                    }
            );
}
