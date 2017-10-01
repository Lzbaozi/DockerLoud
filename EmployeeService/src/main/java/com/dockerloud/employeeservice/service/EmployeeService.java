package com.dockerloud.employeeservice.service;

import com.dockerloud.employeeservice.bean.Employee;

public interface EmployeeService {
	public boolean createEmployee(Employee employee);
	public Employee getEmployee(int id);
}
