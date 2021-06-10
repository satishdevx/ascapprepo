//package com.emirates.asc.parent.controllers;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//class ServiceInstanceRestController {
//	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ServiceInstanceRestController.class);
//
//	@Autowired
//	private DiscoveryClient discoveryClient;
//
//	@GetMapping("/service-instances/{applicationName}")
//	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
//		LOG.info(":::: ServiceInstanceRestController ::: serviceInstancesByApplicationName :::: applicationName");
//		return this.discoveryClient.getInstances(applicationName);
//	}
//}