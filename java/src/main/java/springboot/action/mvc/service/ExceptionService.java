package springboot.action.mvc.service;

import springboot.action.common.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public void businessException(){
        throw new BusinessException();
    }
}
