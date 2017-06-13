package com.kris.controllers.models;

import com.kris.controllers.models.enums.HealthStatus;

public class Health {
	
	private HealthStatus healthStatus;
	
	private String datetime;

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
}
