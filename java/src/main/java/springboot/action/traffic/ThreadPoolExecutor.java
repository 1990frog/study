package springboot.action.traffic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Controller
public class ThreadPoolExecutor {

    // 线程容量
    public static final int N_THREADS = 50;
    // 使用一个线程池用来削峰
    private ExecutorService executor;

    @PostConstruct
    public void init(){
        executor = Executors.newFixedThreadPool(N_THREADS);
    }

    @GetMapping("traffic/executor")
    @ResponseBody
    public String longTimeRun(){
        long start = System.nanoTime();
        work1();
        Future future = executor.submit(()->{
            String ret1 = work2();
            String ret2 = work3();
            log.info(ret1);
            log.info(ret2);
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            log.info("出现异常！");
        } catch (ExecutionException e) {
            log.info("出现异常！");
        }
        long end = System.nanoTime();
        log.info("执行时间={}",(end-start)/1000/1000/1000+"");
        return "success";
    }

    public String work1(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "work1 is done";
    }

    public String work2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "work2 is done";
    }

    public String work3(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "work3 is done";
    }
}
