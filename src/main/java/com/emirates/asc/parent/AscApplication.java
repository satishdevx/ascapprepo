package com.emirates.asc.parent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AscApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(AscApplication.class);

	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		LOG.info(":::: AscApplication ::: main ::::  Start ::");
		SpringApplication.run(AscApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info("---------------------------------------------------------------");
		LOG.info("Application -- " + env.getProperty("spring.application.name"));
		LOG.info("Profile     -- {} ", env.getProperty("spring.profiles.active"));
		LOG.info("Port        -- {} ", env.getProperty("server.port"));
		LOG.info("---------------------------------------------------------------");
	}
}
