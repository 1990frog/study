package action.distributedlock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.locks.Lock;

@Slf4j
@Controller
public class DistributedLockController {

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("redislock")
    @ResponseBody
    public String redisLock() {

        String port = applicationContext.getEnvironment().getProperty("server.port");
        Lock lock = redisLockRegistry.obtain(port);

        try{

            while (lock.tryLock()){
                System.out.println(port+"获取到锁");
                for (int i = 10; i > 0; i--) {
                    Thread.sleep(1000);
                    System.out.println(port+"倒计时-"+i+"s");
                }
                break;
            }
            System.out.println(port+"释放锁");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return "redis lock";
    }

}
