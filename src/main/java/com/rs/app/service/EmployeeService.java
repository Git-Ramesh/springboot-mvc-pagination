package com.rs.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rs.app.model.Employee;

public interface EmployeeService {
	public Page<Employee> getPageOfEmployees(Pageable pageable);
}
