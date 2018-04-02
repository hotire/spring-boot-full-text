package com.googlecode.hotire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.hotire.service.BaseService;

@Controller
public class BaseController {

	@Autowired BaseService baseService;
	
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return "Hello, Spring Boot!";
	}
}
