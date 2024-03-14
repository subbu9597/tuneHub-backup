package com.kod.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kod.tunehub.entity.Song;
import com.kod.tunehub.repository.SongRepository;
import com.kod.tunehub.service.SongService;
@Service
public class SongServiceimpl implements SongService {
	@Autowired
	SongRepository sr;

	@Override
	public String addSong(Song song) {
		sr.save(song);
		return "song added successfully";
	}

	

	@Override
	public boolean songExists(String name) {
		Song song=sr.findByName(name);
		if(song==null) {
			return false;
		}
		return true;
	}



	@Override
	public List<Song> fecthAllSongs() {
		List<Song> s=sr.findAll();
		return s;
	}



	@Override
	public void updateSong(Song s) {
		sr.save(s);
	}






	
}
