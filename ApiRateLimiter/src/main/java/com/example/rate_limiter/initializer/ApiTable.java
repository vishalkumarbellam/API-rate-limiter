package com.example.rate_limiter.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rate_limiter.model.Api;
import com.example.rate_limiter.services.ApiService;

@Component()
public class ApiTable {

	@Autowired
	private ApiService apiService;
	
	//initializes the Api table in the database with these values (milliseconds converted to minutes are commented)
	public void initApi() {
		
		apiService.createApi(new Api("ap1", 100, 1000000));//approx 16 min
		apiService.createApi(new Api("ap2", 10, 120000));//2 min
		apiService.createApi(new Api("ap3", 5, 60000));//1 min
		apiService.createApi(new Api("ap4", 150, 1600000));//approx 26 min
		apiService.createApi(new Api("ap5", 300, 3200000));//approx 53 min
		apiService.createApi(new Api("ap6", 150, 1600000));//approx 26 min
		apiService.createApi(new Api("ap7", 5, 60000));//1 min
		apiService.createApi(new Api("ap8", 20, 240000));//4 min
		apiService.createApi(new Api("ap9", 50, 600000));//10 min
		apiService.createApi(new Api("ap10", 70, 800000));//approx 13 min
		
	}
}
