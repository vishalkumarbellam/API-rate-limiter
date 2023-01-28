package com.example.rate_limiter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rate_limiter.model.Api;
import com.example.rate_limiter.model.ApiCallLog;
import com.example.rate_limiter.model.User;
import com.example.rate_limiter.repositories.LogRepo;

@Service
public class LogService {

	@Autowired
	private LogRepo repo;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ApiService apiservice;
	
	//creates a new log(row) in the table Log
	public void saveLog(ApiCallLog apiCall) {
		repo.save(apiCall);
	}
	
	//performs  all the service
	public String logService(int id, String name) {
		User user = userservice.getUser(id);
		Api api = apiservice.getApi(name);
		
		//checks if user and api are present or not
		if(user != null && api != null) {
			if(updateLog(user, api)) {
				return "called successfully";
			}
			else {
				return "sorry, your limit has exceeded";
			}
		}
		return "user or api not available";
	}
	
	//updates the log(row) in the Log table
	public boolean updateLog(User user, Api api) {
		Optional<ApiCallLog> opt = repo.findById(Integer.toString(user.getUserId())+api.getApiName());
		//if log(row) is not present, creates a new log
		if(opt.isEmpty()) {
			saveLog(new ApiCallLog(Integer.toString(user.getUserId())+api.getApiName(), 
					user.getUserId(), api.getApiName(), 1, calculateLimit(user, api), System.currentTimeMillis()));
			return true;
		}
		
		ApiCallLog apiCall=opt.get();
		
		checkTime(apiCall, api);
		
		if(apiCall.getCallCount()<apiCall.getCallLimit()) {
			apiCall.setCallCount(apiCall.getCallCount()+1);
			repo.save(apiCall);
			return true;
		}
		
		return false;
	}
	
	//calculates the limit 
	public int calculateLimit(User user, Api api) {
		switch (user.getUserType()) {
		case "developer" :
			return api.getMaxLimit()>>1;
		case "organisation" :
			return api.getMaxLimit();
		default:
			throw new IllegalArgumentException("Unexpected value: " + user.getUserType());
		}
	}
	
	//checks if it the api call has reached its reset time
	public void checkTime(ApiCallLog apiCall, Api api) {
		long time=System.currentTimeMillis();
		if(time-apiCall.getStartTime() >= api.getResetTime()) {
			apiCall.setCallCount(0);
			apiCall.setStartTime(time);
			repo.save(apiCall);
		}
	}
}
