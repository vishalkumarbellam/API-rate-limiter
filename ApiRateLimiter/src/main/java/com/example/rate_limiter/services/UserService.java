package com.example.rate_limiter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rate_limiter.model.User;
import com.example.rate_limiter.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	//creates a new user in the table
	public void createUser(User user) {
		repo.save(user);
	}
	
	//checks if the user is present or not
	public User getUser(int id) {
		Optional<User> opt = repo.findById(id);
		if(!opt.isEmpty()) {
			return opt.get();
		}
		return null;
	}
}
