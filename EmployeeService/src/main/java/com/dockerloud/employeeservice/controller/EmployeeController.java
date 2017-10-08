package com.dockerloud.employeeservice.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dockerloud.employeeservice.bean.Employee;
import com.dockerloud.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private EmployeeService service;
    
    @Value("${message1}")  
    private String message1; 
    
    @Value("${message2}")  
    private String message2; 

    @RequestMapping(value = "/getEmployee" ,method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam int id,HttpServletRequest req) {
    	System.out.println(message1);
    	Employee emp = service.getEmployee(id);
    	
    	try {
			InetAddress addr = InetAddress.getLocalHost();
			emp.setEmail(addr.getHostName()+":::"+addr.getHostAddress());
			
			if(req.getSession().getAttribute("count")!=null){
				int count = Integer.parseInt((String) req.getSession().getAttribute("count"));
				count++;
				req.getSession().setAttribute("count", count);
			}else{
				req.getSession().setAttribute("count", 0);
			}
			
			emp.setAge(Integer.parseInt(req.getSession().getAttribute("count").toString()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	
        return emp;
    }

}
