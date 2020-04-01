package springboot.customer.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class SentinelApiController {

    /**
     * 通过Sentinel api降级流控
     * @return
     */
    @GetMapping("sentinel/testapi")
    @ResponseBody
    public String testSentinelAPI() {
        Entry entry = null;
        try {
            SphU.entry("test-sentinel-api");
            return "success";
        }catch (BlockException e){
            log.warn("限流或者降级了",e);
            return "限流或者降级了";
        }finally {
            if(entry!=null)
                entry.exit();
        }
    }
}
