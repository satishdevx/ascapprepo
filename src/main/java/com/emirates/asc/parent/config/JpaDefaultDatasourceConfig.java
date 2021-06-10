package com.emirates.asc.parent.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = { "com.emirates.asc.parent.repositories" })
public class JpaDefaultDatasourceConfig {
	private static final Logger LOG = LoggerFactory.getLogger(JpaDefaultDatasourceConfig.class);

//	@Primary
//	@Bean(name = "dataSource")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		LOG.info(":::: JpaDefaultDatasourceConfig ::: dataSource ::::");
//		return DataSourceBuilder.create().build();
//	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
		LOG.info(":::: JpaDefaultDatasourceConfig ::: entityManagerFactory ::::");
		return builder.dataSource(dataSource).packages(new String[] { "com.emirates.asc.parent.repositories", "com.emirates.asc.parent.entities" }).persistenceUnit("default").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		LOG.info(":::: JpaDefaultDatasourceConfig ::: transactionManager ::::");
		return new JpaTransactionManager(entityManagerFactory);
	}

//	@Autowired
//	private EntityManagerFactory entityManagerFactory;

//	@Bean
//	public SessionFactory getSessionFactory() {
//    LOG.info(":::: JpaDefaultDatasourceConfig ::: getSessionFactory ::::");
//		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
//			throw new NullPointerException("factory is not a hibernate factory");
//		}
//		return entityManagerFactory.unwrap(SessionFactory.class);
//	}
}