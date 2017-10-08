package com.dockerloud.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import com.dockerloud.employeeservice.bean.Employee;
import com.dockerloud.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public boolean createEmployee(Employee employee) {
		return false;
	}

	public Employee getEmployee(int id) {
		
		Employee dummyEmp = new Employee();
		
		dummyEmp.setId(86790);
		dummyEmp.setName("John");
		dummyEmp.setAge(20);
		dummyEmp.setEmail("john@pactera.com");
		
		return dummyEmp;
	}

}
