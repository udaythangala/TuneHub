package com.tunehub.tunehub.services;

import com.tunehub.tunehub.entities.Users;
import com.tunehub.tunehub.repositories.UsersRepository;
import org.apache.catalina.User;
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

        return (repo.findByEmail(email) != null);
    }

    @Override
    public boolean validateUser(String email, String password) {
        Users user = repo.findByEmail(email);
        String db_password = user.getPassword();
        return db_password.equals(password);
    }

    @Override
    public String getRole(String email) {
        Users user = repo.findByEmail(email);
        return user.getRole();
    }

    @Override
    public Users getUser(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public void updateUser(Users user) {
        repo.save(user);
    }

}
