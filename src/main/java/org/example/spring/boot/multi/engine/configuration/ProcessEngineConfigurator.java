package org.example.spring.boot.multi.engine.configuration;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ProcessEngineConfigurator {

    @Bean(name="camundaBpmDataSource")
    @Primary
    @Order(Ordering.DEFAULT_ORDER - 1)
    @ConfigurationProperties(prefix="camunda.datasource")
    public DataSource camundaDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name="camundaBpmTransactionManager")
    @Primary
    @Order(Ordering.DEFAULT_ORDER - 1)
    public PlatformTransactionManager camundaTransactionManager(@Qualifier("camundaBpmDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // Create default engine
    @Bean
    @Primary
    @Order(Ordering.DEFAULT_ORDER - 1)
    @ConfigurationProperties(prefix="default.bpm")
    public SpringProcessEngineConfiguration defaultProcessEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

        config.setDataSource(camundaDataSource());
        config.setTransactionManager(camundaTransactionManager(camundaDataSource()));

        return config;
    }

    // Create tenant1 engine
    @Bean
    @Order(Ordering.DEFAULT_ORDER - 1)
    @ConfigurationProperties(prefix="tenant1.bpm")
    public SpringProcessEngineConfiguration tenant1ProcessEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

        config.setDataSource(camundaDataSource());
        config.setTransactionManager(camundaTransactionManager(camundaDataSource()));

        return config;
    }

    // Create tenant2 engine
    @Bean
    @Order(Ordering.DEFAULT_ORDER - 1)
    @ConfigurationProperties(prefix="tenant2.bpm")
    public SpringProcessEngineConfiguration tenant2ProcessEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

        config.setDataSource(camundaDataSource());
        config.setTransactionManager(camundaTransactionManager(camundaDataSource()));

        return config;
    }



}
