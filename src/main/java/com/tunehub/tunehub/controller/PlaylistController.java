package com.tunehub.tunehub.controller;

import com.tunehub.tunehub.entities.Playlist;
import com.tunehub.tunehub.entities.Song;
import com.tunehub.tunehub.services.PlaylistService;
import com.tunehub.tunehub.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlaylistController {
    @Autowired
    SongService songService;

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/createPlaylist")
    public String createPlaylist(Model model) {

        List<Song> songList = songService.fetchAllSongs();
        model.addAttribute("songs", songList);
        return "createPlaylist";
    }

    @PostMapping("/addPlaylist")
    public String addPlaylist(@ModelAttribute Playlist playlist) {
        // Updating playlist table
        playlistService.addPlaylist(playlist);
        // Updating song table
        List<Song> songList = playlist.getSongs();
        for (Song s : songList) {
            s.getPlaylists().add(playlist);

            // Updating song object in DB
            songService.updateSong(s);
        }
        return "adminHome";
    }

    @GetMapping("/viewPlaylists")
    public String viewPlaylists(Model model) {
        List<Playlist> allPlayLists = playlistService.getPlaylists();
        model.addAttribute("allPlaylists", allPlayLists);
        return "displayPlaylists";
    }
}
