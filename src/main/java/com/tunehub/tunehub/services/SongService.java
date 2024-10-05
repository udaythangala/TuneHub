package com.tunehub.tunehub.services;

import com.tunehub.tunehub.entities.Song;

import java.util.List;

public interface SongService {
    public void addSong(Song song);

    public List<Song> fetchAllSongs();

    public boolean songExists(String name);
}