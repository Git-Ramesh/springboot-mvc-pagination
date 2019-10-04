package com.rs.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rs.app.model.Employee;
import com.rs.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Page<Employee> getPageOfEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}
}
