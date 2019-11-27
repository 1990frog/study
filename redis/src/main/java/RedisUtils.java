import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtils {

    private static final String ip = "127.0.0.1";
    private static final int port = 6379;
    private static JedisPool jedisPool;//懒汉式单例模式，存在并发安全问题

    public static Jedis getInstance(){
        synchronized (RedisUtils.class){
            if(jedisPool==null){
                jedisPool = new JedisPool(new GenericObjectPoolConfig(),ip, port);
            }
        }
        return jedisPool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = RedisUtils.getInstance();
        jedis.set("hello","world");
    }

}
