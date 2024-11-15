package com.tunehub.tunehub.services;

import com.tunehub.tunehub.entities.Playlist;
import com.tunehub.tunehub.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlaylistServiceImplementation implements PlaylistService{

    @Autowired
    PlaylistRepository repo;
    @Override
    public void addPlaylist(Playlist playlist) {
        repo.save(playlist);
    }

    @Override
    public List<Playlist> getPlaylists() {
        return repo.findAll();
    }
}
