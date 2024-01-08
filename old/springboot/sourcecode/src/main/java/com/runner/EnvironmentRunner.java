package com.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentRunner implements ApplicationRunner, EnvironmentAware {

    private Environment env;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(env.getProperty("user"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
