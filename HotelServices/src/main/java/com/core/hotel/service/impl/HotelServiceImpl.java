package com.core.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.hotel.entity.Hotel;
import com.core.hotel.repository.HotelRepository;
import com.core.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> getAllHotelDetails() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getSingleHotelDetails(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).get();
	}

	@Override
	public List<Hotel> getHotelDetailsByName(String hotelName) {
		// TODO Auto-generated method stub
		return hotelRepository.findByName(hotelName).get();
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotel.setId( UUID.randomUUID().toString() );
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public String deleteHotelDetail(String hotelId) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(hotelId);
		return "Record Deleted Succesfully";
	}

}
