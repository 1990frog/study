package com.action.transational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 这个类用于测试事务的传播
 *
 * 事务嵌套调用：
 * 1.required调用not_supported，在方法里触发异常：都未插入数据，说明required的事务传递给了not_supported
 * 2.not_supported调用required，在方法里触发异常：有一条数据not_supported，required未插入到数据库
 *
 * 结论：
 * 事务可以从上游传递给下游？
 */
@Component
public class PropagationTr {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 事务传播等级：
     * required（默认事务传播）
     *
     * 自我介绍：
     * “能用就凑合，没有在弄个新的”
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'REQUIRED')");
//        ((PropagationTr) AopContext.currentProxy()).notSupported();//通过required去调用notSupported
        throw new RuntimeException();
    }

    /**
     * 事务传播等级：
     * not_supported
     *
     * 自我介绍：
     * “就是不用，有也不用”
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported(){
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (2, 2, 'NOT_SUPPORTED')");
//        ((PropagationTr) AopContext.currentProxy()).required();
        throw new RuntimeException();
    }

    /**
     * 事务传播等级requires_new
     *
     * 自我介绍：
     * “不管有没有，我都要新的事务”
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew(){
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (3, 3, 'REQUIRES_NEW')");
    }

}






