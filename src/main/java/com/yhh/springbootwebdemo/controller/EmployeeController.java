package com.yhh.springbootwebdemo.controller;

import com.yhh.springbootwebdemo.dao.EmployeeDao;
import com.yhh.springbootwebdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author: yuhaohan
 * @date: 星期二
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping(value = "/emps")
	public String list(Model model){
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("emps", all);
		return "emp/list";
	}

}
