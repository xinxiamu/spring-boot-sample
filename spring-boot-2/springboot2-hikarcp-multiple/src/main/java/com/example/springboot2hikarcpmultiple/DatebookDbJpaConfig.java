package com.example.springboot2hikarcpmultiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryMyself", transactionManagerRef = "transactionManagerMyself", basePackages = {"com.example.springboot2hikarcpmultiple"})
public class DatebookDbJpaConfig {

	@Autowired
	@Qualifier("masterDataSource")
	private DataSource masterDataSource; // 数据源

	@Bean(name = "entityManagerFactoryMyself")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryMyself(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean emFactory = builder.dataSource(masterDataSource).properties(myselfJpaProperties().getProperties())
				.packages("com.example.springboot2hikarcpmultiple") // 设置数据表对应实体类所在位置
				.persistenceUnit("datebook").build(); //设置持久化管理工厂别名
		return emFactory;

	}


	@Primary
	@Bean(name = "transactionManagerMyself")
	public PlatformTransactionManager transactionManagerMyself(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryMyself(builder).getObject());
	}

	@ConfigurationProperties(prefix = "spring.datebook.jpa")
	@Bean(name = "datebookJpaProperties")
	@Primary
	public JpaProperties myselfJpaProperties() {
		return new JpaProperties();
	}



}