package com.core.user.service;

import java.util.List;

import com.core.user.entity.User;

public interface UserService {

	public List<User> findAllUserDetail();
	
	public User findSingleUserDetail(String userID);
	
	public List<User> findUserDetailByName(String username);
	
	public List<User> findUserDetailByEmail(String userEmail);
	
	public List<User> findUserDetailByNameAndEmail(String username,String userEmail);
	
	public User  createUser(User user);
	
	public User updateUser(User user);
	
	public String removeUserDetail(String userID);
}
