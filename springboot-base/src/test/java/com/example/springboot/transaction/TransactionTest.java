package com.example.springboot.transaction;

import com.ActionSpringbootApplication;
import com.transaction.DeclarativeTransaction;
import com.transaction.ProgrammaticTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest(classes = {ActionSpringbootApplication.class})
public class TransactionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProgrammaticTransaction program;
    @Autowired
    private DeclarativeTransaction declare;

    @Test
    public void test1(){
        program.execute();
    }

    @Test
    public void test2(){
        declare.execute();
    }

    /**
     * 2020-03-05 13:36:33.071  INFO 21008 --- [           main] c.e.s.transaction.TransactionTest        : AAA 1
     * 2020-03-05 13:36:33.080  INFO 21008 --- [           main] c.e.s.transaction.TransactionTest        : BBB 0
     * 2020-03-05 13:36:33.089  INFO 21008 --- [           main] c.e.s.transaction.TransactionTest        : BBB 1
     */
    @Test
    public void test3(){
        declare.insertRecord();
        log.info("AAA {}",
                jdbcTemplate
                        .queryForObject("SELECT COUNT(*) FROM transaction WHERE name='AAA'", Long.class));
        try {
            declare.insertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM transaction WHERE name='BBB'", Long.class));
        }

        try {
            declare.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                    jdbcTemplate
                            .queryForObject("SELECT COUNT(*) FROM transaction WHERE name='BBB'", Long.class));
        }
    }

}
