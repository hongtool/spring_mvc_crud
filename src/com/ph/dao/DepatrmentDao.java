package com.ph.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ph.POJO.Department;

public class DepatrmentDao {
	private static Map<Integer, Department> depts;
	static {
		depts = new HashMap<Integer, Department>();
		depts.put(1, new Department(1, "SALES"));
		depts.put(2, new Department(2, "HR"));
	}
	
	public static Collection<Department> getAllDepts() {
		return depts.values();
	}
	public static Department getDeptById(Integer id) {
		return depts.get(id);
	}
}
