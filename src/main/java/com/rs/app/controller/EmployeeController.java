package com.rs.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rs.app.model.Employee;
import com.rs.app.service.EmployeeService;
import com.rs.app.util.JacksonUtil;

import lombok.extern.slf4j.Slf4j;

// http://localhost:8081/employee/page?page=0&size=3&sort=id,asc&sort=name,desc
@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/page")
	public String getPageOfEmployees(Map<String, Object> model, Pageable pageable) {
		log.debug(JacksonUtil.convertToJson(pageable));
//		Sort sort = pageable.getSort();yee
//		sort.forEach(order -> {
//			System.out.println(order.getProperty() + "=" + order.getDirection().name());
//		});
//		return ResponseEntity.ok(employeeService.getPageOfEmployees(pageable));
		Page<Employee> page = employeeService.getPageOfEmployees(pageable);
//		PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>();
//		pagedListHolder.setPage(pageable.getPageNumber());
//		pagedListHolder.setPageSize(page.getPageable().getPageSize());
//		pagedListHolder.setSource(page.getContent());
//		pagedListHolder.setMaxLinkedPages(page.getTotalPages());
//		model.put("pageInfo", pagedListHolder);
//		model.put("activePage", page.getPageable().getPageNumber());
//		model.put("phones", Arrays.asList("'Phone-1'", "'Phone-2'", "'Phone-3'"));
//		model.put("pageNumbers", 2);
//		model.put("pageStart")
		model.put("page", page);
		model.put("isFirst", page.isFirst());
		model.put("isLast", page.isLast());
		model.put("hasNext", page.hasNext());
		model.put("hasPrevious", page.hasPrevious());
		model.put("pageSize", page.getPageable().getPageSize());
		return "employees";
	}

}
