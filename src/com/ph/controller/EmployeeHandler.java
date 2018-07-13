package com.ph.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ph.POJO.Employee;
import com.ph.dao.DepatrmentDao;
import com.ph.dao.EmployeeDao;

@Controller
public class EmployeeHandler {

	private final String SUCCESS = "success";
	private final String INPUT = "input";

	@RequestMapping(value="/allEmps", method=RequestMethod.GET)
	public String allEmps(Map<String, Object> map) {
		map.put("emps", EmployeeDao.getAllEmps());
		return SUCCESS;

	}
	
	/**
	 * 完成用户输入界面的跳转，包括增加员工信息和修改员工信息
	 */
	@RequestMapping(value="/input/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		//获取所有性别信息
		Map<Integer, Object> genders = new HashMap<Integer, Object>();
		genders.put(0, "MALE");
		genders.put(1, "FEMALE");
		map.put("genders", genders);
		Employee employee = new Employee();
		if(id != 0) {
			employee = EmployeeDao.getEmpById(id);
		}
		//数据回显，使用springmvc标签，则其key值必须为command
//		map.put("command", new Employee());
		map.put("abc", employee);
		//获取所有部门信息
		map.put("depts", DepatrmentDao.getAllDepts());
		return INPUT;
	}
	//添加员工信息后重定向到查询
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String add(Employee employee) {
		EmployeeDao.save(employee);
		return "redirect:/allEmps";
	}
	
	//删除员工信息后重定向到查询
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		EmployeeDao.delete(id);
		return "redirect:/allEmps";
	}
	
	@ModelAttribute
	public void attri(Integer id, Map<String, Object> map) {
		if(id != null) {
			Employee employee = EmployeeDao.getEmpById(id);
			map.put("employee", employee);
		}
	}
	//修改员工信息
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee emp) {
		EmployeeDao.update(emp.getId(), emp);
		return "redirect:/allEmps";
	}
	
	@InitBinder
	public void testInitBinder(WebDataBinder binder) {
		//禁止name属性的赋值
		binder.setDisallowedFields("name");
	}
}
