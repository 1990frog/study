package springboot.customer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * productor对应的feign
 */
//@FeignClient(name = "productor",configuration = GlobalFeignConfiguration.class)
@FeignClient(name = "productor")
public interface ProductorFeignClient {

    @GetMapping("/productor")
    String queryProduct();
}
