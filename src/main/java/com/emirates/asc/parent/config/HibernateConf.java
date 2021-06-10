package com.emirates.asc.parent.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
//public class HibernateConf {
//	private static final Logger LOG = LoggerFactory.getLogger(HibernateConf.class);

//	@Autowired
//	@Qualifier("dataSource")
//	DataSource dataSource;

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LOG.info(":::: HibernateConf ::: sessionFactory ::::");
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan("com.emirates.asc.parent.repositories");
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		return sessionFactory;
//	}
//
//	@Bean(name = "dataSource")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		LOG.info(":::: HibernateConf ::: dataSource ::::");
//		return DataSourceBuilder.create().build();
//	}

//	@Bean(name = "h2DataSource")
//    public DataSource dataSource() {
//		LOG.info(":::: HibernateConf ::: dataSource ::::");
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
////        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
////      return builder.setType(EmbeddedDatabaseType.H2).build();
//        return dataSource;
//    }

//	@Bean
//	public PlatformTransactionManager hibernateTransactionManager() {
//		LOG.info(":::: HibernateConf ::: hibernateTransactionManager ::::");
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory().getObject());
//		return transactionManager;
//	}

//	private final Properties hibernateProperties() {
//		LOG.info(":::: HibernateConf ::: hibernateProperties ::::");
//		Properties hibernateProperties = new Properties();
//		// hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//		hibernateProperties.setProperty("hibernate.show_sql", "hibernate.show_sql");
//		hibernateProperties.setProperty("hibernate.format_sql", "hibernate.format_sql");
//		return hibernateProperties;
//	}
//}