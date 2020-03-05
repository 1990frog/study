package com.configuration;

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
public class CustomerDataSourceConfiguration {

    @Bean("customerDataSourceProperties")
    @ConfigurationProperties("customer.datasource")
    public DataSourceProperties customerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("customerDataSource")
    public DataSource secondDataSource() {
        DataSourceProperties dataSourceProperties = customerDataSourceProperties();
        log.info("bar datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager secondTxManager(@Qualifier("customerDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean("customerJdbcTemplate")
    @Resource
    public JdbcTemplate jdbcTemplate(@Qualifier("customerDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
