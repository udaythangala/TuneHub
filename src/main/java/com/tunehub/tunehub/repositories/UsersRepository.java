package com.tunehub.tunehub.repositories;

import com.tunehub.tunehub.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    public Users findByEmail(String email);
}
