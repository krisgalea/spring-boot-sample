package com.kris.controllers.models;

public class Resource {

	String resourceUrl;
	
	public Resource(){
		
	}
	
	public Resource(String resourceUrl){
		this.resourceUrl= resourceUrl;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	
}
