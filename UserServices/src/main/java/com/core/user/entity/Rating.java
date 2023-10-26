package com.core.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
	private Hotel hotel;

}
