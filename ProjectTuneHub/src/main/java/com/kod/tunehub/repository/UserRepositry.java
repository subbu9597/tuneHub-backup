package com.kod.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kod.tunehub.entity.User;

public interface UserRepositry  extends JpaRepository<User,String>{

	// @Query("SELECT u.emil from User u where u.email= :email")
	
	public User findByEmail (String email);
}
