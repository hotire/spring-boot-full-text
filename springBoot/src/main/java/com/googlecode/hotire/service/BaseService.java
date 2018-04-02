package com.googlecode.hotire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.hotire.repository.BaseRepository;

@Service
public class BaseService {

	@Autowired BaseRepository baseRepository;
	
	public String hello() {
		return "Hello, Spring Boot!";
	}
}
