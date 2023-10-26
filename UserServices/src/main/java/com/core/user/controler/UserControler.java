package com.core.user.controler;

import java.util.List;

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

import com.core.user.entity.User;
import com.core.user.service.UserService;



import org.slf4j.Logger;

@RestController
@RequestMapping(path ="/userServices/users")
public class UserControler {
	
	Logger logger=LoggerFactory.getLogger(UserControler.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping()	
	public ResponseEntity<List<User>> getUserDetail() {
		return new ResponseEntity<List<User>>(userService.findAllUserDetail(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path =  "/{userId}")
	public ResponseEntity<User> getUserDetailById(@PathVariable("userId") String userId) {
		return new ResponseEntity<User>(userService.findSingleUserDetail(userId),HttpStatus.OK);
	}
	
	
	@GetMapping(path ="/search")
	public ResponseEntity<List<User>> searchUserDetail(@RequestParam(name = "userName", required = false,defaultValue = "null") String userName,@RequestParam(name = "userEmail" , required = false, defaultValue = "null") String userEmail){
		
		logger.info("userName : {}, userEmail : {}", userName,userEmail);
		
		if(!userName.equals("null") && !userEmail.equals("null"))
			return new ResponseEntity<List<User>>(userService.findUserDetailByNameAndEmail(userName, userEmail),HttpStatus.OK);
		else if(!userName.equals("null"))
			return new ResponseEntity<List<User>>(userService.findUserDetailByName(userName),HttpStatus.OK);
		else if(!userEmail.equals("null"))
			return new ResponseEntity<List<User>>(userService.findUserDetailByEmail(userEmail),HttpStatus.OK);
		else
			return new ResponseEntity<List<User>>(userService.findAllUserDetail(),HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
	}
	
	@DeleteMapping(path ="{user_id}")
	public ResponseEntity<String> removeSingleUser(@PathVariable("user_id") String UserId){
		return new ResponseEntity<String>( userService.removeUserDetail(UserId), HttpStatus.OK);
	}
	
}
