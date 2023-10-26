package com.core.rating.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.core.rating.entity.Rating;

@Service
public interface RatingService {
	
	public List<Rating> getRatingDetail();
	
	public Rating getSignleRatingDetail(String ratingId);
	
	public List<Rating> getRatingDetailByUserId(String userId);
	public List<Rating> getRatingDetailByHotelId(String hotelId);
	public List<Rating> getRatingDetailByUserIdAndHotelId(String userId,String hotelId);
	
	
	public Rating createRating(Rating rating);
	
	public Rating updateRating(Rating rating);
	
	public String removeRating(String ratingId);
	

}
