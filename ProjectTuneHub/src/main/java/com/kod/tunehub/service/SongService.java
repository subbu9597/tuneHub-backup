package com.kod.tunehub.service;

import java.util.List;

import com.kod.tunehub.entity.Song;

public interface SongService {

	public String addSong(Song song);

	public boolean songExists(String name);

	public List<Song> fecthAllSongs();

	public void updateSong(Song s);

	

}
