package springboot.action.annotation.asysc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

import static java.lang.Thread.currentThread;

@Slf4j
@Controller
public class AsyscController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("asysc")
    @ResponseBody
    public String foo(){
        log.info("入口方法线程id = {}", currentThread().getId());
        /**
         * error
         * 因为foo没有动态代理增强对象
         */
        try{
            ((AsyscController) AopContext.currentProxy()).bar();
        }catch (Exception e){
            System.out.println("error");
        }

        /**
         * right
         * 通过上下文获取增强后的对象
         * 创建了一个新线程去执行bar
         */
        applicationContext.getBean(AsyscController.class).bar();

        /**
         * this调用，用的是一般对象
         * threadid相同
         */
        bar();

        /**
         * 返回值
         */
        Future<String> result = applicationContext.getBean(AsyscController.class).baz();
//        while (true) {
//            if(result.isDone()){
//                try {
//                    log.info("async有返回值方法，线程id = {}", result.get());
//                    break;
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return "";
    }

    /**
     * 无返回值的Async用法
     */
    @Async
    public void bar(){
        log.info("async无返回值方法，线程id = {}", currentThread().getId());
    }

    /**
     * 有返回值的Async用法
     * @return
     */
    @Async
    public Future<String> baz(){
        Future<String> future = new AsyncResult<String>(Thread.currentThread().getId()+"");
        return future;
    }

}
