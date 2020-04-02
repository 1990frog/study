package springboot.action.aop.annotation;

import springboot.action.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DecodeController {

    @GetMapping("/annotation/decode")
    @ResponseBody
    @Decode
    public Result decode(){
        Entity entity = Entity.builder()
                .value("1")
                .build();
        return Result.builder(entity);
    }

}
