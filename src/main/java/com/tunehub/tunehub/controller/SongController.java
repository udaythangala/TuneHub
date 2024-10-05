package com.tunehub.tunehub.controller;


import com.tunehub.tunehub.entities.Song;
import com.tunehub.tunehub.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongService service;
    @PostMapping("/addSong")
    public String addSong(@ModelAttribute Song song) {
        boolean songStatus = service.songExists(song.getName());
        if (!songStatus) {
            service.addSong(song);
            System.out.println("Song added");
        }else {
            System.out.println("Song already exists");
        }
        return "adminHome";
    }

    @GetMapping("/viewSongs")
    public String viewSongs(Model model) {
        List<Song> songsList = service.fetchAllSongs();
        model.addAttribute("songs", songsList);
        return "displaySongs";
    }

    @GetMapping("/playSongs")
    public String playSongs(Model model) {

        boolean premiumUser = false;
        if (premiumUser) {
            List<Song> songsList = service.fetchAllSongs();
            model.addAttribute("songs", songsList);
            return "displaySongs";
        } else {
            return "makePayment";
        }
    }

}

