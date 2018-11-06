package com.example.ymu;

import com.example.ymu.exception.ExceptionTranslator;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-17 上午10:57
 * @updateTime
 * @since 1.0.0
 */
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
public class MainConfig {

    @Autowired
    private DataSource testDbDataSource;

   /* @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dt = new DataSourceTransactionManager();
        dt.setDataSource(testDbDataSource);
        return dt;
    }*/

   /* @Bean
    public SpringTransactionProvider  transactionProvider() {
        return new SpringTransactionProvider();
    }*/

   /* @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
        TransactionAwareDataSourceProxy tp = new TransactionAwareDataSourceProxy();
        tp.setTargetDataSource(testDbDataSource);
        return tp;
    }*/

    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProvider() {
        DataSourceConnectionProvider dp = new DataSourceConnectionProvider(testDbDataSource);
        return dp;
    }

    private ExceptionTranslator exceptionTranslator() {
        return new ExceptionTranslator();
    }

    @Bean
    public DefaultConfiguration jooqConfig() {
        DefaultConfiguration config = new DefaultConfiguration();
        config.setSQLDialect(SQLDialect.MYSQL);
        config.setConnectionProvider(dataSourceConnectionProvider());
//        config.setTransactionProvider(transactionProvider());

        DefaultExecuteListenerProvider defaultExecuteListenerProvider = new DefaultExecuteListenerProvider(exceptionTranslator());
        config.setExecuteListenerProvider(defaultExecuteListenerProvider);

        return config;
    }

    @Bean
    public DefaultDSLContext jooqDsl(DefaultConfiguration jooqConfig) {
        DefaultDSLContext dsl = new DefaultDSLContext(jooqConfig);
        return dsl;
    }

}
