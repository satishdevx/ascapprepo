//package com.emirates.asc.parent.config;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "anotherEntityManagerFactory", transactionManagerRef = "anotherTransactionManager", basePackages = {
//		"com.emirates.asc.parent.repositories" })
//public class JpaAnotherDatasourceConfig {
//	private static final Logger LOG = LoggerFactory.getLogger(JpaAnotherDatasourceConfig.class);
//
//	@Bean(name = "anotherDataSource")
//	@ConfigurationProperties(prefix = "spring.second-datasource")
//	public DataSource anotherDataSource() {
//		LOG.info(":::: JpaAnotherDatasourceConfig ::: dataSource ::::");
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "anotherEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean anotherEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("anotherDataSource") DataSource anotherDataSource) {
//		LOG.info(":::: JpaAnotherDatasourceConfig ::: anotherEntityManagerFactory ::::");
//		return builder.dataSource(anotherDataSource).packages("com.test.app.sample.*").persistenceUnit("second").build();
//	}
//
//	@Bean(name = "anotherTransactionManager")
//	public PlatformTransactionManager anotherTransactionManager(@Qualifier("anotherEntityManagerFactory") EntityManagerFactory anotherEntityManagerFactory) {
//		LOG.info(":::: JpaAnotherDatasourceConfig ::: anotherTransactionManager ::::");
//		return new JpaTransactionManager(anotherEntityManagerFactory);
//	}
//}