package com.kod.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@GetMapping("/index")
    public String index() {
        return "index";
    }
	
	@GetMapping("/newsong")
    public String newsong() {
        return "newsong";
    }
	

	@GetMapping("/adminhome")
    public String adminhome() {
        return "adminhome";
    }
	@GetMapping("/Index")
    public String Index() {
        return "Index";
    }
}

