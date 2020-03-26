package com.action.transational;

import com.action.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Controller
public class DeclarativeTransaction {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 默认
     */
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'AAA')");
    }

    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (2, 2, 'BBB')");
        throw new RollbackException();
    }

    /**
     * Spring AOP 同类调用失效问题
     *
     * insertThenRollback()等同与this.insertThenRollback()
     * this表示的是当前的对象，而不是代理对象，因此注解失效
     *
     * 动态代理对象 ！= 当前对象
     */
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
        // 解决方法1：最简单的方法就是将aop扫描的方法放在另外的一个类中进行调用，就不会出现这种问题了

        // 解决方法2：
        ((DeclarativeTransaction)(AopContext.currentProxy())).invokeInsertThenRollback();

        // 解决方法3：往实现类中注入自身。 仍然在同一个类中调用代码

    }

    @Transactional
    public Result execute(){

        try{
            log.info("dbsize is {}",getCount());
            jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (3, 3, 'CCC')");
            throw new RuntimeException();
        }catch (Exception e){
            throw e;
        }finally {
            // 这里多打出一条数据，是因为finally发生在抛出异常之前，而抛出异常才会触发事务
            log.info("dbsize is {}",getCount());
        }
    }

    private long getCount() {
        return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM transaction")
                .get(0).get("CNT");
    }


}
