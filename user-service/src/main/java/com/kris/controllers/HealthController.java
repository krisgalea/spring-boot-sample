package com.kris.controllers;


import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kris.controllers.models.Health;
import com.kris.controllers.models.enums.HealthStatus;

/**
 * 
 * @author kris
 * 
 * Controller used for simple health check to ensure module is up and running  
 *
 */
@RestController
public class HealthController {
	
	@RequestMapping(path = "/health", method= RequestMethod.GET)
	public Health getHealthStatus(){
		Health healthCheck = new Health();		
		healthCheck.setDatetime(DateTime.now().toString());
		healthCheck.setHealthStatus(HealthStatus.OK);
		return healthCheck;
	}
	
}
