package com.kod.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kod.tunehub.entity.Song;
import com.kod.tunehub.entity.User;
import com.kod.tunehub.service.SongService;
import com.kod.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService us;

	@Autowired
	SongService ss;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {

		//Email taken from the  registration from
		String email=user.getEmail();

		//checking if email as entered in registration form is present in db
		boolean status=us.emilExists(email);
		if(status==false) {
			us.addUser(user);
			System.out.println("user added");
			return "home";

		}else {
			System.out.println("user with entered Email already exist ..");
			return "login";
		}
	}

	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email ,@RequestParam("password") String password, HttpSession session,Model model) {

		if(us.validateUser(email,password)==true) {

			String role=us.getRole(email);
			session.setAttribute("email", email);
			
			String a="Admin";

			if(role.equals(a)) {
				return "adminhome";

			}else {
				
				User user=us.getUser(email);
				boolean us=user.isIspremium();
				
				//logic 
				List<Song> fas=ss.fecthAllSongs();
				model.addAttribute("songs",fas);
				
				model.addAttribute("ispremium",us);
				
				
				return "customerhome";
			}
		}
		else {
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession ses) {
		ses.invalidate();
		
		return "login";
	}
	
	
}
