package com.example.practicejpa.controller;

import com.example.practicejpa.servies.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {

    @Autowired
    private userservice userservice;
    
    @PostMapping("/auth/comfirm")
    public String checkemail(@RequestParam("email")String email) {
        System.out.println("email");
        String yesorno=userservice.checkemail(email);
        return yesorno;
    }
}
