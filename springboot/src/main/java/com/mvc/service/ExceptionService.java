package com.mvc.service;

import com.common.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public void businessException(){
        throw new BusinessException();
    }
}
