package com.core.user.entity;

public enum HttpUrls {

	//RATING_SERVICE("http://localhost:8082/ratingServices/ratings/search"),
	RATING_SERVICE("http://RATING-SERVICES/ratingServices/ratings/search"),
	//HOTEL_SERVICE("http://localhost:8083/hotelService/hotels/search");
	HOTEL_SERVICE("http://HOTEL-SERVICE/hotelService/hotels");
	
	private String serviceUrl;

	private HttpUrls(String serviceUrl) {
		this.serviceUrl=serviceUrl;
	}

	public String getServicUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	
	
	
}
