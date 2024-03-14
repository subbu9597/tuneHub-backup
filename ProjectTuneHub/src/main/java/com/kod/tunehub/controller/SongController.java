package com.kod.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kod.tunehub.entity.Song;
import com.kod.tunehub.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService ss;
	
@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song s){
	
	boolean sstatus=ss.songExists(s.getName());
	
	if(sstatus==false) {
		
		ss.addSong((s));
		System.out.println("Song added done ");
		return "newsong";
	}
	else {
		System.out.println("Song is alredy added ");
		
	}
	return "adminhome";
	
		
	}
 

@GetMapping("/viewsongs")
public String viewsongs(Model m) {
	List<Song> sl=ss.fecthAllSongs();
	m.addAttribute("songs",sl);
	return "displaysongs";
}





}

