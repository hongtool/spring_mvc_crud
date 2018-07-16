package com.ph.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public String testFormat(@Valid User user, BindingResult result, Map<String, Object> map) {
//		if(result.getErrorCount() > 0) {
//			List<ObjectError> errors = result.getAllErrors();
//			for(ObjectError error : errors) {
//				System.out.println(error.getDefaultMessage());
//			}
//		}
		//获取字段的错误消息
//		if(result.getFieldErrorCount() > 0) {
//			List<FieldError> fieldErrors = result.getFieldErrors();
//			for(FieldError fieldError : fieldErrors) {
//				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
//			}
//		}
		if(result.getFieldErrorCount() > 0) {
			map.put("user", user);
			return "format";
		}
		System.out.println(user);
		return "success";
	}
	@RequestMapping("/toFormat")
	public String toFormat(Map<String, Object> map) {
		map.put("user", new User());
		return "format";
	}
}
