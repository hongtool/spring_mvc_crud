package com.ph.controller;

import org.springframework.stereotype.Controller;
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
}
