package com.example.rate_limiter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rate_limiter.model.Api;
import com.example.rate_limiter.repositories.ApiRepo;

@Service
public class ApiService {

	@Autowired
	ApiRepo repo;
	
	//creates a new api in the table
	public void createApi(Api api) {
		repo.save(api);
	}
	
	//checks if the given api is present or not
	public Api getApi(String name) {
		Optional<Api> opt = repo.findById(name);
		if(!opt.isEmpty()) {
			return opt.get();
		}
		return null;
	}
}
