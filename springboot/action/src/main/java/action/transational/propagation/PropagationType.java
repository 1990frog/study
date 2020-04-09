package action.transational.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class PropagationType {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    private static final String sql = "INSERT INTO transaction (id, code, name) VALUES (%s, %s, %s)";

    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        jdbcTemplate.execute(String.format(sql,"1","1","REQUIRED"));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports() {
        jdbcTemplate.execute(String.format(sql,"2","1","SUPPORTS"));
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory() {
        jdbcTemplate.execute(String.format(sql,"3","1","MANDATORY"));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew() {
        jdbcTemplate.execute(String.format(sql,"4","1","REQUIRES_NEW"));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported() {
        jdbcTemplate.execute(String.format(sql,"5","1","NOT_SUPPORTED"));
    }

    @Transactional(propagation = Propagation.NEVER)
    public void never() {
        jdbcTemplate.execute(String.format(sql,"6","1","NEVER"));
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nested() {
        jdbcTemplate.execute(String.format(sql,"7","1","NESTED"));
    }


}
