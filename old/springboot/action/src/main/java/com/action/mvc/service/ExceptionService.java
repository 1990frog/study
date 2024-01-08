package com.action.mvc.service;

import com.action.common.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public void businessException(){
        throw new BusinessException();
    }
}
