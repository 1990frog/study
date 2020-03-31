package com.springboot.action;

import com.SpringbootApplication;
import com.util.createdata.MySqlData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest(classes = SpringbootApplication.class)
public class InsertData {

    @Autowired
    private MySqlData mySqlData;

    @Test
    public void test(){
//        ExecutorService executorService = Executors.newFixedThreadPool(300);
//        for (int i = 0; i < 200; i++) {
//            executorService.submit(()->mySqlData.insert());
//        }
//
//        executorService.shutdown();
//        while (executorService.isTerminated()){
//            System.out.println("end!");
//        }
        mySqlData.insert();
    }

}
