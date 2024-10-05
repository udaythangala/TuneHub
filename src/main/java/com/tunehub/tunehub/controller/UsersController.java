package com.tunehub.tunehub.controller;

import com.tunehub.tunehub.entities.Users;
import com.tunehub.tunehub.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
    @Autowired
    UsersService service;

    @PostMapping("/register")
    public String addUsers(@ModelAttribute Users user) {

        boolean userStatus = service.emailExists(user.getEmail());
        if (!userStatus) {
            service.addUser(user);
            System.out.println("User added");
        }else {
            System.out.println("User already exists");
        }

        return "home";
    }

    @PostMapping("/validate")
    public String validate(@RequestParam("email") String email, @RequestParam("password") String password) {
        if(service.validateUser(email, password)) {
            String role = service.getRole(email);
            if(role.equals("admin")) {
                return "adminHome";
            }else {
                return "customerHome";
            }
        }
        else {
            return "login";
        }
    }

}
