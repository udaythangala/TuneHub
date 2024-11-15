package com.tunehub.tunehub.services;

import com.tunehub.tunehub.entities.Playlist;

import java.util.List;

public interface PlaylistService {

    public void addPlaylist(Playlist playlist);
    public List<Playlist> getPlaylists();
}
