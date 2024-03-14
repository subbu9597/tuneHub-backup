package com.kod.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kod.tunehub.entity.Song;

public interface SongRepository extends 
JpaRepository<Song,Integer>{

	public Song findByName(String name);


	

}
