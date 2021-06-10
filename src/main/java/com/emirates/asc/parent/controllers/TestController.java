package com.emirates.asc.parent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emirates.asc.parent.services.TestService;

@RestController
@RequestMapping(path = "/test")
public class TestController {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService testService;
	
	@GetMapping("/data")
	public String getTestData() {
		LOG.info(":::: TestController ::: getTestData ::::");
		return testService.getTestData();
	}

}
