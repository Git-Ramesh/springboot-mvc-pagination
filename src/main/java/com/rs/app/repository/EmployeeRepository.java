package com.rs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
