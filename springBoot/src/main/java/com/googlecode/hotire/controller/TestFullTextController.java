package com.googlecode.hotire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.hotire.model.ResponseMessage;
import com.googlecode.hotire.service.TestFullTextService;

/**
 * 
 * @author : hoTire
 * @comment : Test Controller
 */
@Controller
public class TestFullTextController extends BaseController{

	@Autowired TestFullTextService testFullTextService;
	private final static String TEST_DATA = "10011000010000100001000010000";
	
	@RequestMapping({"/test","/"})
	public @ResponseBody ResponseMessage test(String testData) {
		testData = testData == null ? TEST_DATA : testData;
		return testFullTextService.test(testData);
	}
}
