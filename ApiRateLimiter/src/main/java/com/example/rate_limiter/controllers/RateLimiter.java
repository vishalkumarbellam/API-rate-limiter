package com.example.rate_limiter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rate_limiter.initializer.ApiTable;
import com.example.rate_limiter.initializer.UserTable;
import com.example.rate_limiter.repositories.ApiRepo;
import com.example.rate_limiter.repositories.UserRepo;
import com.example.rate_limiter.services.LogService;

@RestController
public class RateLimiter {

	@Autowired
	private LogService apiCall;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ApiRepo apiRepo;
	
	@Autowired
	private UserTable userTable;
	
	@Autowired
	private ApiTable apiTable;
	
	@RequestMapping("/apicall/{id}/{name}")
	public String func(@PathVariable(name = "id") int id, @PathVariable(name = "name") String name) {
		
		if(userRepo.count() == 0) {
			userTable.initTable();
		}
		
		if(apiRepo.count() == 0) {
			apiTable.initApi();
		}
		
		return apiCall.logService(id, name);
	}
	
}
