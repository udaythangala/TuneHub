package com.tunehub.tunehub.repositories;

import com.tunehub.tunehub.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {

    public Song findByName(String name);
}
