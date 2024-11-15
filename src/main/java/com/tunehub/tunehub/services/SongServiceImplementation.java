package com.tunehub.tunehub.services;

import com.tunehub.tunehub.entities.Song;
import com.tunehub.tunehub.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImplementation implements SongService {
    @Autowired
    SongRepository repo;

    @Override
    public void addSong(Song song) {
        repo.save(song);
    }

    @Override
    public List<Song> fetchAllSongs() {
        return repo.findAll();
    }

    @Override
    public boolean songExists(String name) {
        return (repo.findByName(name) != null);
    }

    @Override
    public void updateSong(Song song) {
        repo.save(song);
    }


}
