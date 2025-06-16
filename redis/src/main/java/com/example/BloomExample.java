package com.example;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class BloomExample {
 public static void main(String[] args) {
    Config config = new Config();
    config.useSingleServer()
        .setAddress("redis://localhost:6379")
        .setDatabase(0)
        .setPassword("your_password_here");
    
    // 构造 Redisson
    RedissonClient redisson = Redisson.create(config);
    try {
        // 创建布隆过滤器
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("myBloomFilter");
        bloomFilter.tryInit(1000, 0.01); // 初始化，预计存储1000个元素，误判率为1%

        // 添加元素
        bloomFilter.add("element1");
        bloomFilter.add("element2");

        // 检查元素是否存在
        boolean exists1 = bloomFilter.contains("element1"); // true
        boolean exists2 = bloomFilter.contains("element3"); // false

        System.out.println("element1 exists: " + exists1);
        System.out.println("element3 exists: " + exists2);
    } finally {
        // 关闭 Redisson 客户端
        redisson.shutdown();
    }
 }
}
