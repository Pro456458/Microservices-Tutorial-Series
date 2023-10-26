package com.core.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.user.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {
	
	
	public List<User>  findByName(String name);
	public List<User>  findByEmail(String email);
	List<User> findDistinctByEmailAndName(String email, String name);
	
	
}
