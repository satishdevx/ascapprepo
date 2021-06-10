package com.emirates.asc.parent.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({ 
		@PropertySource(value = "classpath:/application-${spring.profiles.active}.yml", ignoreResourceNotFound = true),
		})
public class PropertiesWithJavaConfig {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesWithJavaConfig.class);

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		LOG.info(":::: PropertiesWithJavaConfig ::: placeHolderConfigurer ::::");
		return new PropertySourcesPlaceholderConfigurer();
	}

}