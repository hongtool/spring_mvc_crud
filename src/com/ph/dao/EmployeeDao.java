package com.ph.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ph.POJO.Employee;

public class EmployeeDao {
	
	private static Map<Integer, Employee> emps;
	
	static {
		emps = new HashMap<Integer, Employee>();
		emps.put(101, new Employee(101, "AA", "AA@qq.com", 0, DepatrmentDao.getDeptById(2)));
		emps.put(102, new Employee(102, "BB", "BB@qq.com", 1, DepatrmentDao.getDeptById(1)));
		emps.put(103, new Employee(103, "CC", "CC@qq.com", 0, DepatrmentDao.getDeptById(2)));
		emps.put(104, new Employee(104, "DD", "DD@qq.com", 1, DepatrmentDao.getDeptById(1)));
		emps.put(105, new Employee(105, "EE", "EE@qq.com", 0, DepatrmentDao.getDeptById(1)));
		
	}
	//获取所有员工信息，并将其转为集合形式
	public static Collection<Employee> getAllEmps() {
		return emps.values();
	}
	//添加员工信息
	private static Integer key = 106;
	public static void save(Employee emp) {
		emp.setId(key);
		emp.setDept(DepatrmentDao.getDeptById(emp.getDept().getDeptId()));
		emps.put(key++, emp);
	}
	
	//删除员工信息
	public static void delete(Integer id) {
		emps.remove(id);
	}
	
	//根据id查询员工信息
	public static Employee getEmpById(Integer id) {
		return emps.get(id);
	}
	
	//根据id修改员工信息
	public static void update(Integer id, Employee emp) {
		emp.setDept(DepatrmentDao.getDeptById(emp.getDept().getDeptId()));
		emps.put(id, emp);
	}
}
