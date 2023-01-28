package com.example.rate_limiter.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rate_limiter.model.User;
import com.example.rate_limiter.services.UserService;

@Component
public class UserTable {

	@Autowired
	private UserService userService;
	
	//initializes the User table in the database with these values
	public void initTable() {
		
		userService.createUser(new User("user1", "organisation"));
		userService.createUser(new User("user2", "developer"));
		userService.createUser(new User("user3", "developer"));
		userService.createUser(new User("user4", "organisation"));
		userService.createUser(new User("user5", "developer"));
		userService.createUser(new User("user6", "organisation"));
		userService.createUser(new User("user7", "organisation"));
		userService.createUser(new User("user8", "developer"));
		userService.createUser(new User("user9", "developer"));
		userService.createUser(new User("user10", "organisation"));
		userService.createUser(new User("user12", "developer"));
		userService.createUser(new User("user13", "organisation"));
		
	}
}
