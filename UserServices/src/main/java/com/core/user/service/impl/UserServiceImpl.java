package com.core.user.service.impl;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.core.user.entity.Hotel;
import com.core.user.entity.HttpUrls;
import com.core.user.entity.Rating;
import com.core.user.entity.User;
import com.core.user.repository.UserRepository;
import com.core.user.service.UserService;
import com.core.user.service.external.HotelServices;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelServices hotelServices;
	
	
	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> findAllUserDetail() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findSingleUserDetail(String userID) {
		// TODO Auto-generated method stub
		User user= userRepository.findById(userID).get();
		
		user.setRating(getListOfRatingGivenByUser_UsingRestTemplate(userID));
		
		return user;
	}
	
	private List<Rating>  getListOfRatingGivenByUser_UsingRestTemplate(String userId){
		
		List<Rating> ratingList=null;
		Rating[] rating;
		
		HttpUrls httpUrls;
		
		try {
			
			Map<String, String> requestPeram=new HashMap<>();
			requestPeram.put("userId", userId);
			//requestPeram.put("hotelId", "null");
			
			httpUrls= HttpUrls.RATING_SERVICE;
			logger.info("rating service URL : {}"+ httpUrls.getServicUrl()+"?userId={userId}");
			
			ResponseEntity<Rating[]> ratingListResponse =restTemplate.getForEntity(httpUrls.getServicUrl()+"?userId="+userId, Rating[].class);
			
			logger.info("rating detal service response : {} ", ratingListResponse.getStatusCode());
			
			rating= ratingListResponse.getBody();
			ratingList=new ArrayList<>(rating.length);
			for(int i=0;i <rating.length;i++) {
				
				Rating ratingBean=rating[i];
				
				
				String hotelId=rating[i].getHotelId();
				httpUrls= HttpUrls.HOTEL_SERVICE;
				
				logger.info("hotel id from rating beans : {}", hotelId);
				logger.info("hotel service url : {}", httpUrls.getServicUrl()+"/"+hotelId);
				
				/* *
				 * calling hotel micro service using rest Template 
				 * */
				/*
				 * ResponseEntity<Hotel> responseEntityHotelBean=restTemplate.exchange(
				 * httpUrls.getServicUrl()+"/"+hotelId, HttpMethod.GET, null, new
				 * ParameterizedTypeReference<Hotel>() {} );
				 * 
				 * logger.info("hotel bean response exchange {}",responseEntityHotelBean.getBody());
				 * ratingBean.setHotel(responseEntityHotelBean.getBody());
				 */
				
				
				Hotel responseEntityHotelBean= hotelServices.getHotel(hotelId);
				logger.info("hotel bean {}",responseEntityHotelBean);
				ratingBean.setHotel(responseEntityHotelBean);
				
				ratingList.add(ratingBean);
				
			}
			
			logger.info("rating detal : {}", Arrays.toString(rating));
			
		
		} catch (RestClientException e) {
			logger.error("having some issue while calling Rating service : {}" + e.toString() );
			e.printStackTrace();
		}
		
		return ratingList;
		
	}
	
	@Override
	public List<User> findUserDetailByName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByName(username);
	}

	@Override
	public List<User> findUserDetailByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(userEmail);
	}
	
	@Override
	public List<User> findUserDetailByNameAndEmail(String username, String userEmail) {
		// TODO Auto-generated method stub
		return userRepository.findDistinctByEmailAndName(userEmail, username);
	}
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		user.setUserID(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public String removeUserDetail(String userID) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userID);
		return "USER DELETED SUCCESFULLY";
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
