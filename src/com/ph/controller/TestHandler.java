package com.ph.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph.POJO.User;

@Controller
public class TestHandler {

	//前端通过文本框描述用户信息(name,age)
	@RequestMapping("/testConversionService")
	public String testConversionService(User user) {
		System.out.println(user);
		return "success";
	}
	
	@RequestMapping("/testFormat")
	public String testFormat(@Valid User user, BindingResult result) {
		System.out.println(user);
		if(result.getErrorCount() > 0) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
		}
		return "success";
	}
}
