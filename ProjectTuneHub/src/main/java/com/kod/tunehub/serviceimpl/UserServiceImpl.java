package com.kod.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kod.tunehub.entity.User;
import com.kod.tunehub.repository.UserRepositry;
import com.kod.tunehub.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepositry ur;

	@Override
	public String addUser(User user) {
		ur.save(user);
		
		return "User added succesfully";
	}
	
	//To check the duplicate entries
	

	public boolean emilExists(String email) {
		if(ur.findByEmail(email)!=null) {
			return true;
		} else {
		return false;
		}
	}
	
	
	
	
	public boolean validateUser(String email, String password) {
		
		User u=ur.findByEmail(email);
		
		String dbpw=u.getPassword();
		
		if(password.equals(dbpw)) {
			return true;
		}
		else {
		return false;
		}
	}
	

	
	public String getRole(String email) {

		User user=ur.findByEmail(email);
		return user.getRole();
	}

	
	
	@Override
	public User getUser(String email) {
		
		
		return ur.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		ur.save(user);
	}

	
	

	



	

}
