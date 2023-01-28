package com.example.rate_limiter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Logs")
public class ApiCallLog {

	@Id
	private String logId;
	private int userId;
	private String apiName;
	private int callCount;
	private int callLimit;
	private long startTime;
	public ApiCallLog() {
		
	}
	public ApiCallLog(String logId, int userId, String apiName, int callCount, int callLimit, long startTime) {
		super();
		this.logId = logId;
		this.userId = userId;
		this.apiName = apiName;
		this.callCount = callCount;
		this.callLimit = callLimit;
		this.startTime = startTime;
	}
	public int getCallLimit() {
		return callLimit;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public int getCallCount() {
		return callCount;
	}
	public void setCallCount(int callCount) {
		this.callCount = callCount;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
}
