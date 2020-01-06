package sentinel;

import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class RedisSentinelPool {

    private static final String MASTER_NAME = "master";
    private static final Set<String> SENTINEL_SET = new HashSet<String>(){
        {
            add("127.0.0.1:26379");
            add("127.0.0.1:26380");
        }
    };


    public static JedisSentinelPool getSentinelPool(){
        JedisSentinelPool sentinelPool = new JedisSentinelPool(MASTER_NAME,SENTINEL_SET);
        return sentinelPool;
    }
}
