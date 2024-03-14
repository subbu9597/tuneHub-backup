package com.kod.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kod.tunehub.entity.Playlist;

public interface PlaylistRepository 
extends JpaRepository<Playlist,Integer> {

	public Playlist findByName(String name);

}
