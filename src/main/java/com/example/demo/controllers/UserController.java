package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String rejestracja (Model model){
        return "";

    }
    @PostMapping("/register")
    public String rejestracjaAkcja (Model model){
        return "";
    }


    @GetMapping("/login")
    public String loginForm (){




        return "logowanie";
    }}
