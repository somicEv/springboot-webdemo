package com.yhh.springbootwebdemo.controller;

import com.yhh.springbootwebdemo.dao.DepartmentDao;
import com.yhh.springbootwebdemo.dao.EmployeeDao;
import com.yhh.springbootwebdemo.entities.Department;
import com.yhh.springbootwebdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author: yuhaohan
 * @date: 星期二
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@GetMapping(value = "/emps")
	public String list(Model model) {
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("emps", all);
		return "emp/list";
	}

	@GetMapping(value = "/emp")
	public String toAddPage(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		return "emp/add";
	}

	@PostMapping(value = "/emp")
	public String addEmp(Employee employee) {
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
