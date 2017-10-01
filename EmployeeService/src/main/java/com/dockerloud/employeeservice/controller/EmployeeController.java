package com.dockerloud.employeeservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/getEmployee" ,method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam int id) {
        return service.getEmployee(id);
    }

}
