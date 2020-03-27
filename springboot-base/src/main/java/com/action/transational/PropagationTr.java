package com.action.transational;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PROPAGATION_REQUIRED -- 支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。 
 * PROPAGATION_SUPPORTS -- 支持当前事务，如果当前没有事务，就以非事务方式执行。 
 * PROPAGATION_MANDATORY -- 支持当前事务，如果当前没有事务，就抛出异常。 
 * PROPAGATION_REQUIRES_NEW -- 新建事务，如果当前存在事务，把当前事务挂起。 
 * PROPAGATION_NOT_SUPPORTED -- 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。 
 * PROPAGATION_NEVER -- 以非事务方式执行，如果当前存在事务，则抛出异常。 
 * PROPAGATION_NESTED -- 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则进行与
 *
 * 事务嵌套调用：
 * 1.required调用not_supported，在方法里触发异常：都未插入数据，说明required的事务传递给了not_supported
 * 2.not_supported调用required，在方法里触发异常：有一条数据not_supported，required未插入到数据库
 *
 * 结论：
 * 事务可以从上游传递给下游？
 */
@Controller
public class PropagationTr {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 事务传播等级：
     * required（默认事务传播）
     * 自我介绍：“不介意二手”
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'REQUIRED')");
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredException() {
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'REQUIRED')");
        throw new RuntimeException();
    }

    /**
     * 事务传播等级：
     * not_supported
     * 自我介绍：“就是不用，有也不用”
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported(){
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (2, 2, 'NOT_SUPPORTED')");
    }
    @GetMapping("/tx/not")
    @ResponseBody
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupportedException(){
        this.notSupported();
        throw new RuntimeException();
    }

    /**
     * 事务传播等级requires_new
     * 自我介绍：“不管有没有，我都要新的事务”
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew(){
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (3, 3, 'REQUIRES_NEW')");
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNewException(){
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (3, 3, 'REQUIRES_NEW')");
        throw new RuntimeException();
    }


    /**
     * 测试情景：
     * REQUIRED事务调用NOT_SUPPORTED事务,NOT_SUPPORTED中抛出异常
     *
     * 运行结果：
     *
     */
    @GetMapping("/tx/req2not")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void req2not(){
        System.out.println(this);
        jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'REQUIRED')");

//        ((PropagationTr) AopContext.currentProxy()).notSupportedException();
        applicationContext.getBean(PropagationTr.class).notSupportedException();
//        this.notSupportedException();
    }

    @GetMapping("/tx/not2req")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void not2req(){

    }

    @GetMapping("/tx/req2new")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void req2new(){

    }

    @GetMapping("/tx/new2req")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void new2req(){

    }

    @GetMapping("/tx/new2new")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void new2new(){

    }

    //解决事务失效
    private PropagationTr getService(){
        return applicationContext.getBean(this.getClass());   //SpringUtil工具类见下面代码
    }



}






