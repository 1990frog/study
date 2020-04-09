package action.transational.base;

import action.transational.RollbackException;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class AnnWrongUsage {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 自定义异常触发事务
     * @throws RollbackException
     */
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

        /**
         * 错误用法1：通过this直接调用，这么不会触发aop动态代理
         */
        insertThenRollback();

        /**
         * 错误用法2：在类中注入自己，循环依赖
         * @Autowired
         * private DeclarativeTransaction declarativeTransaction;
         */
        //declarativeTransaction.invokeInsertThenRollback();

        /**
         * 正确用法1：最简单的方法就是将aop扫描的方法放在另外的一个类中进行调用，就不会出现这种问题了
         */
        // otherclass.transationalMethod()

        /**
         * 正确用法2：aopproxy调用
         */
        ((AnnWrongUsage)(AopContext.currentProxy())).invokeInsertThenRollback();

        /**
         * 正确用法3：通过spring上下文
         */
        applicationContext.getBean(AnnWrongUsage.class).invokeInsertThenRollback();

    }
}
