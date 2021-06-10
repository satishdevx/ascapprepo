package com.emirates.asc.parent.services;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.emirates.asc.parent.controllers.TestController;

@Service
@Transactional
public class TestServiceImpl implements TestService {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TestController.class);
	
	@Override
	public String getTestData() {
		LOG.info(":::: TestServiceImpl ::: getTestData ::::");
		return "Test Success";
	}

}
