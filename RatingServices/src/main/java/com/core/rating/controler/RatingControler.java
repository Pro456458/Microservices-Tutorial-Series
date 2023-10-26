package com.core.rating.controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.rating.entity.Rating;
import com.core.rating.service.RatingService;

@RestController
@RequestMapping("/ratingServices/ratings")
public class RatingControler {
	
	Logger logger=LoggerFactory.getLogger(RatingControler.class);
	
	@Autowired
	RatingService ratingService;
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatingDetail(){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingDetail(),HttpStatus.OK);
	}
	
	@GetMapping(path ="/{ratingId}")
	public ResponseEntity<Rating> getSignleRatingDetail(@PathVariable("ratingId") String ratingId){
		return new ResponseEntity<Rating>(ratingService.getSignleRatingDetail(ratingId),HttpStatus.OK);
	}
	
	@GetMapping(path="/search")
	public ResponseEntity<List<Rating>> searchRatingDetail(@RequestParam(name ="userId", required = false, defaultValue = "null") String userId,@RequestParam(name ="hotelId", required = false,defaultValue = "null") String hotelId ){
		
		logger.info("Request recived for search Rating with userId :{} ,and HotelId :{}", userId,hotelId );
		
		
		if(!userId.equals("null") && !hotelId.equals("null"))
			return new ResponseEntity<List<Rating>>(ratingService.getRatingDetailByUserIdAndHotelId(userId, hotelId),HttpStatus.OK);
		else if(!userId.equals("null"))
			return new ResponseEntity<List<Rating>>(ratingService.getRatingDetailByUserId(userId),HttpStatus.OK);
		else if(!hotelId.equals("null"))
			return new ResponseEntity<List<Rating>>(ratingService.getRatingDetailByHotelId(hotelId),HttpStatus.OK);
		else
			return new ResponseEntity<List<Rating>>(ratingService.getRatingDetail(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Rating> createRatingDetail(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.createRating(rating),HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Rating> updateRatingDetail(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.updateRating(rating),HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{ratingId}")
	public ResponseEntity<String> deleteRatingDetail(@PathVariable("ratingId") String ratingId){
		return new ResponseEntity<String>(ratingService.removeRating(ratingId),HttpStatus.CREATED);
	}
	

}
