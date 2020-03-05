package com.aware;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ResultCommandLineRunner implements CommandLineRunner, EnvironmentAware, MyAware {

    private Environment env;

    private Flag flag;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(env.getProperty("username"));
        System.out.println(env.getProperty("userpwd"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }

    @Override
    public void setFlag(Flag fla) {
        flag = fla;
    }
}
