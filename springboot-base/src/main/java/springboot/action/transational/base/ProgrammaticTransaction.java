package springboot.action.transational.base;

import springboot.action.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class ProgrammaticTransaction {

    /**
     * 事务模板
     */
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * sql无返回结果
     */
    @GetMapping("/transaction/execute/program")
    @ResponseBody
    public Result execute(){
        log.info("dbsize is {}",getCount());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.execute("INSERT INTO transaction (id, code, name) VALUES (1, 1, 'aaa')");
                log.info("dbsize is {}",getCount());
                transactionStatus.setRollbackOnly();
            }
        });

        log.info("dbsize is {}",getCount());
        return Result.builder(null);
    }

    /**
     * sql有返回结果
     */
    @GetMapping("/transaction/query/program")
    @ResponseBody
    public Result query(){
        // 有返回
        return Result.builder(transactionTemplate.execute((TransactionCallback<List>) status -> jdbcTemplate.queryForList("select * from transaction")));
    }

    private long getCount() {
        return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM transaction")
                .get(0).get("CNT");
    }
}
