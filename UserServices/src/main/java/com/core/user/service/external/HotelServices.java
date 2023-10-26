package com.core.user.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.core.user.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServices {

	
	@GetMapping(("/hotelService/hotels/{hotelId}"))
	public Hotel getHotel(@PathVariable String hotelId);
	
	
	@GetMapping(("/hotelService/hotels"))
	public List<Hotel> getAllHotelDetail();
	
}
