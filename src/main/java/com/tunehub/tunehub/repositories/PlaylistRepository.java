package com.tunehub.tunehub.repositories;

import com.tunehub.tunehub.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
