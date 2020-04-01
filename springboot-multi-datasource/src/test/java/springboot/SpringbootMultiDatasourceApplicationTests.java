package springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class SpringbootMultiDatasourceApplicationTests {

    @Autowired
    @Qualifier("productorJdbcTemplate")
    private JdbcTemplate productorJdbcTemplate;

    @Autowired
    @Qualifier("customerJdbcTemplate")
    private JdbcTemplate customerJdbcTemplate;

    @Test
    void contextLoads() {
        log.info("db1 read start");
        log.info(String.valueOf(productorJdbcTemplate.queryForList("select * from productor")));
        log.info("db1 read end");

        log.info("db2 read start");
        log.info(String.valueOf(customerJdbcTemplate.queryForList("select * from customer")));
        log.info("db2 read end");
    }

}
