package com.emirates.asc.parent.config;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatasourceConfig {
	private static final Logger LOG = LoggerFactory.getLogger(DatasourceConfig.class);

	@Profile("default")
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource defaultDataSource() {
		LOG.info(":::: DatasourceConfig ::: defaultDataSource ::::");
		return DataSourceBuilder.create().build();
	}

	@Profile("dev")
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource devDataSource() {
		LOG.info(":::: DatasourceConfig ::: devDataSource ::::");
		return DataSourceBuilder.create().build();
	}

	@Profile("tst")
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource testDataSource() {
		LOG.info(":::: DatasourceConfig ::: testDataSource ::::");
		return DataSourceBuilder.create().build();
	}

	@Profile("stg")
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource stageDataSource() {
		LOG.info(":::: DatasourceConfig ::: stageDataSource ::::");
		return DataSourceBuilder.create().build();
	}

	@Profile("prod")
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource prodDataSource() {
		LOG.info(":::: DatasourceConfig ::: prodDataSource ::::");
		return DataSourceBuilder.create().build();
	}
}
