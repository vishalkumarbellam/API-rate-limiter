package com.example.rate_limiter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Api {

	@Id
	private String apiName;
	private int maxLimit;
	private long resetTime;
	public Api() {
		
	}
	public Api(String apiName, int maxLimit, long resetTime) {
		super();
		this.apiName = apiName;
		this.maxLimit = maxLimit;
		this.resetTime=resetTime;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public int getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	public Long getResetTime() {
		return resetTime;
	}
}
