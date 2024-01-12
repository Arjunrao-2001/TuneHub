package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Song;

public interface SongService {

	public List<Song> fetchAllSongs() ;

	public void addSong(Song song);

	public boolean songExists(String name);

	public void updateSong(Song song);

	
}
