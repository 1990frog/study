package springboot.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@Configuration
public class ProductorDataSourceConfiguration {


    @Bean("productorSourceProperties")
    @ConfigurationProperties("productor.datasource")
    public DataSourceProperties productorSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("productorDataSource")
    public DataSource productorDataSource() {
        DataSourceProperties dataSourceProperties = productorSourceProperties();
        log.info("productor datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager firstTxManager(@Qualifier("productorDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean("productorJdbcTemplate")
    @Resource
    public JdbcTemplate jdbcTemplate(@Qualifier(value = "productorDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "productorTransactionManager")
    public PlatformTransactionManager testTransactionManager(@Qualifier("productorDataSource") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

}
