package sentinel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisSentinelFalloverTest {

    private static Logger logger = LoggerFactory.getLogger(RedisSentinelFalloverTest.class);

    public static JedisSentinelPool createPool(){
        final String MASTER_NAME = "main";
        final Set<String> SENTINEL_SET = new HashSet<String>(){
            {
                add("127.0.0.1:26379");
                add("127.0.0.1:26380");
            }
        };
        JedisSentinelPool sentinelPool = new JedisSentinelPool(MASTER_NAME,SENTINEL_SET);
        return sentinelPool;
    }

    public static void main(String[] args) throws InterruptedException {
        JedisSentinelPool jedisSentinelPool = createPool();

        Jedis jedis = jedisSentinelPool.getResource();
        for(int i=0;i<10000;i++){
//            jedis = jedisSentinelPool.getResource();
            int index = new Random().nextInt();
            String key = "k-"+index;
            String value = "v-"+index;
            jedis.set(key,value);
//                if(counter%100==0){
//                    logger.info("{} value is {}",key,jedis.get(key));
//                }
            logger.info("{} value is {}",key,jedis.get(key));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

    }
}
