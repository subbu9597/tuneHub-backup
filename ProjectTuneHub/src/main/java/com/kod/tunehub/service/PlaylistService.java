package com.kod.tunehub.service;

import java.util.List;

import com.kod.tunehub.entity.Playlist;

public interface PlaylistService {

	

	public void addplaylist(Playlist p);


	public List<Playlist> fecthAllPlaylists();




	public boolean palyExists(String name);

	

}
