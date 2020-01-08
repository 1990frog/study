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

    public static void main(String[] args) {
        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<String>(){
            {
                add("127.0.0.1:26379");
                add("127.0.0.1:26380");
            }
        };
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName,sentinels);

        int counter = 0;
        while (true){
            counter++;
            Jedis jedis = null;
            try{
                jedis = jedisSentinelPool.getResource();
                int index = new Random().nextInt(100000);
                String key = "k-"+index;
                String value = "v-"+index;
                jedis.set(key,value);
                if(counter%100==0){
                    logger.info("{} value is {}",key,jedis.get(key));
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
            }
        }

    }
}
