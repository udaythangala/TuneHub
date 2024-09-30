package com.tunehub.tunehub.services;

import com.tunehub.tunehub.entities.Users;
import com.tunehub.tunehub.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImplementation implements UsersService {

    @Autowired
     UsersRepository repo;

    @Override
    public String addUser(Users user) {
        repo.save(user);
        return "user added successfully";
    }

    @Override
    public boolean emailExists(String email) {

        if(repo.findByEmail(email) == null){
            return false;
        } else{
            return true;
        }
    }

}
