package action.mvc.controller;

import action.common.BusinessErrorEnum;
import action.common.BusinessException;
import action.mvc.domain.param.RequestParam;
import util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Slf4j
@Controller
public class ParamValidController {

    @GetMapping("params/1")
    @ResponseBody
    public void inject1(@Valid @RequestBody RequestParam params, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BusinessException(BusinessErrorEnum.PARAM_ERROR,ErrorUtil.processErrorString(bindingResult));
        }
    }

    @GetMapping("params/2")
    @ResponseBody
    public void inject2(@Valid @RequestBody RequestParam params){

    }
}
