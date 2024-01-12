package com.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.Song;
import com.tunehub.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean songstatus = service.songExists(song.getName());
		if(songstatus == false)
		{
		service.addSong(song);
		System.out.println("Song added successfully");
		}
		else
		{
			System.out.println("Song already exists");
		}
		return "adminHome";
	}
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		model.addAttribute("songs", service.fetchAllSongs());
		return "displaySongs";	
	}
	
	
	
	
	@GetMapping("/playSongs")
	public String playSongs(Model model)
	{
		boolean premiumuser=false;
		
		if(premiumuser==true)
		{
			List<Song> songsList = service.fetchAllSongs();
			System.out.println(songsList);
			model.addAttribute("songs", songsList);
			return "displaySongs";
		}
		else
		{
			return "makePayment";
		}
		
	}
	
	 
}
