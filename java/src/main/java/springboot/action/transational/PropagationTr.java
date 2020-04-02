package springboot.action.transational;

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
 */
@Controller
public class PropagationTr {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    private static final String sql = "INSERT INTO transaction (value) VALUES ('%s')";


    /**
     * 事务传播等级：
     * required（默认事务传播）
     * 自我介绍：“不介意二手”
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        jdbcTemplate.execute(String.format(sql,"required"));
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredException() {
        jdbcTemplate.execute(String.format(sql,"required_exception"));
        throw new RuntimeException();
    }

    /**
     * 事务传播等级：
     * not_supported
     * 自我介绍：“就是不用，有也不用”
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported(){
        jdbcTemplate.execute(String.format(sql,"not_supported"));
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupportedException(){
        jdbcTemplate.execute(String.format(sql,"not_supported_exception"));
        throw new RuntimeException();
    }

    /**
     * 事务传播等级requires_new
     * 自我介绍：“不管有没有，我都要新的事务”
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew(){
        jdbcTemplate.execute(String.format(sql,"requires_new"));
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNewException(){
        jdbcTemplate.execute(String.format(sql,"requires_new_exception"));
        throw new RuntimeException();
    }

    /**
     * 场景1：
     * this调用
     *
     * 期望结果：
     *  1.插入required（失败）
     *  2.插入not_supported_exception（成功）
     *
     * 实际结果：
     *  1.插入required（失败）
     *  1.插入not_supported_exception（失败）
     *
     * 原因：
     * 因为未使用增强代理对象调用，所以notSupportedException方法的注解失效，整个调用链使用的都是入口方法的注解REQUIRED级别的事务
     */
    @GetMapping("/tx/1")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void test1(){
        jdbcTemplate.execute(String.format(sql,"required"));
        this.notSupportedException();
    }

    /**
     * 场景2：
     * AopContext，ApplicationContext
     *
     * 期望结果：
     *  1.插入required（失败）
     *  2.插入not_supported_exception（成功）
     *
     * 实际结果：
     *
     * 原因：
     * 使用的增强代理对象调用，所以第二个注解触发，会将第一个注解挂起，先执行第二个注解
     */
    @GetMapping("/tx/2")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void test2(){
        jdbcTemplate.execute(String.format(sql,"required"));
        ((PropagationTr)AopContext.currentProxy()).notSupportedException();
    }



}






