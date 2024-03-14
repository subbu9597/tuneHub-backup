package com.kod.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kod.tunehub.entity.Playlist;
import com.kod.tunehub.entity.Song;
import com.kod.tunehub.service.PlaylistService;
import com.kod.tunehub.service.SongService;

@Controller
public class PlaylistController {
	@Autowired
	SongService ss;
	
	@Autowired
	PlaylistService ps;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model m) {
		List<Song> sl=ss.fecthAllSongs();
		m.addAttribute("songs",sl);
		return "createplaylist";
	}
	
	
@PostMapping("/addplaylist")
public String addplaylist(@ModelAttribute Playlist p) {
	
	
	//update the playlist table
	ps.addplaylist(p);
	
	//updating the song table
	List<Song> songlist=p.getSongs();
	for(Song s:songlist) {
		s.getPlaylists().add(p);
		// update the song_playlist
		ss.updateSong(s);
	}
	return "adminhome";
}



@GetMapping("/viewplaylist")
public String viewplaylist(Model m) {
List<Playlist>	apl=ps.fecthAllPlaylists();
m.addAttribute("apl",apl);
	return "displayplaylist";
	
}


@GetMapping("/serch")
public String serch(@ModelAttribute Song s,Model m) {
	List<Song> ssl=ss.fecthAllSongs();
	m.addAttribute("ssongs",ssl);
	return "displaysongs";
	
	
	
	
	
	
//	List<Song> ssl=ss.fecthAllSongs();
//	m.addAttribute("ssongs",ssl);
//	return "displaysongs";
}





}
