package com.ph.POJO;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class User {

	private String name;
	
	@Email
	private String email;
	
	@Range(min = 1, max = 150)
	private Integer age;
	
	@NumberFormat(pattern = "#,###.##")
	private Double salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date birth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", salary=" + salary + ", birth=" + birth + "]";
	}

}
