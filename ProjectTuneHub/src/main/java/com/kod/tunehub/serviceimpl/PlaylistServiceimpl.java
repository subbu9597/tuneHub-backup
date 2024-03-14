package com.kod.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kod.tunehub.entity.Playlist;
import com.kod.tunehub.repository.PlaylistRepository;
import com.kod.tunehub.service.PlaylistService;

@Service
public class PlaylistServiceimpl implements PlaylistService {
	@Autowired
	PlaylistRepository pr;


	@Override
	public void addplaylist(Playlist p) {
		pr.save(p);
	}



	@Override
	public List<Playlist> fecthAllPlaylists() {
	List<Playlist>	apl=pr.findAll();
		return apl;
	}



	@Override
	public boolean palyExists(String name) {
		Playlist p=pr.findByName(name);
		if(p==null) {
			return false;
		}
		return true;
	}

}
