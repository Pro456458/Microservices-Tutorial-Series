package com.core.hotel.service;

import java.util.List;

import com.core.hotel.entity.Hotel;

public interface HotelService {
	
	public List<Hotel> getAllHotelDetails();
	
	public Hotel getSingleHotelDetails(String hotelId);
	
	public List<Hotel> getHotelDetailsByName(String hotelName);
	
	public Hotel createHotel(Hotel hotel);
	
	public Hotel updateHotel(Hotel hotel);
	
	public String deleteHotelDetail(String hotelId);

}
