package com.kod.tunehub.service;

import com.kod.tunehub.entity.User;

public interface UserService {
	
	public String addUser(User user);
	
	public boolean emilExists(String email);
	
	public boolean validateUser(String email,String password);

	public String getRole(String email);

	
	public User getUser(String email);
	
     public void updateUser(User user);


}
