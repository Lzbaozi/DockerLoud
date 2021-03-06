package com.dockerloud.balancer.employeeservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@Configuration
@EnableAutoConfiguration
public class EmployeeController {

	private final Logger logger = Logger.getLogger(getClass());

	@Value("${message1}")
	private String message1;

	@Value("${message2}")
	private String message2;

	@Autowired
	RestTemplate rt;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/test/login", method = RequestMethod.GET)
	public String login(@RequestParam int id,HttpServletRequest request) {
		String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		if (StringUtils.isNotBlank(sessionId)) {
			HttpHeaders headers = new HttpHeaders();  
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);  
			headers.set("x-auth-token", request.getHeader("x-auth-token"));
			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(null, headers);  
			ResponseEntity<String> response = rt.exchange( "http://EMPLOYEE-SERVICE/login", HttpMethod.GET, requestEntity , String.class );  
			return response.getBody();
        }
		return rt.getForEntity("http://EMPLOYEE-SERVICE/getEmployee?id=" + id, String.class).getBody();
		
	}
	
	@RequestMapping(value = "/test/getEmployee", method = RequestMethod.GET)
	public String getEmployee(@RequestParam int id,HttpServletRequest request) {
		
		String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
		if (StringUtils.isNotBlank(sessionId)) {
			HttpHeaders headers = new HttpHeaders();  
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);  
			headers.set("x-auth-token", request.getHeader("x-auth-token"));
			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(null, headers);  
			ResponseEntity<String> response = rt.exchange( "http://EMPLOYEE-SERVICE/getEmployee?id=" + id, HttpMethod.GET, requestEntity , String.class );  
			return response.getBody();
        }
		return rt.getForEntity("http://EMPLOYEE-SERVICE/getEmployee?id=" + id, String.class).getBody();
		
	}

}
