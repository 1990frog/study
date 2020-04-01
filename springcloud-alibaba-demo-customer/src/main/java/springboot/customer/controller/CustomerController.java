package springboot.customer.controller;

import springboot.customer.feignclient.ProductorFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    private ProductorFeignClient productor;

    /**
     * 访问消费者
     * @return
     */
    @GetMapping("/customer")
    @ResponseBody
    public String customer(){
        return "success";
    }

    /**
     * 消费者通过feign调用生产者
     * @return
     */
    @GetMapping("/customer/feign")
    @ResponseBody
    public String clientProductor(){
        return productor.queryProduct();
    }
}
