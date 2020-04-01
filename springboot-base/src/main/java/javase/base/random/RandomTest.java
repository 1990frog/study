package javase.base.random;

import java.util.Random;
import java.util.UUID;

/**
 * 产生随机id的4种方法
 */
public class RandomTest {

    public static void main(String[] args) {
        // 产生指定范围内的随机数
        System.out.println(new Random().nextInt(10));
        // 参数随机浮点数
        System.out.println(Math.random());
        // 获取当前时间
        System.out.println(System.currentTimeMillis());
        // UUID
        System.out.println(UUID.randomUUID());
    }
}
