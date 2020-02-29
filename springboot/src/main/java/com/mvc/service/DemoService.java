package com.mvc.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DemoService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

//    private UserMapper userMapper;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String initializerTest(String key) {
        return applicationContext.getEnvironment().getProperty(key);
    }

    public boolean insertUser(){
//        User user = new User();
//        user.setName("cai");
//        userMapper.insertSelective(user);
        return true;
    }

}
