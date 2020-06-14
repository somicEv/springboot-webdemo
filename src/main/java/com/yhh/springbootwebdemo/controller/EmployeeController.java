package com.yhh.springbootwebdemo.controller;

import com.yhh.springbootwebdemo.dao.DepartmentDao;
import com.yhh.springbootwebdemo.dao.EmployeeDao;
import com.yhh.springbootwebdemo.entities.Department;
import com.yhh.springbootwebdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping(value = "/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id, Model model) {
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp", employee);
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		// 重用ADD页面
		return "emp/add";
	}

	@PutMapping(value = "/emp")
	public String updateEmployee(Employee employee) {
		System.out.println("要修改的员工信息：" + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	@PostMapping(value = "/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
