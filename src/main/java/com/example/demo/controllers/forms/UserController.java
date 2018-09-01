package com.example.demo.controllers.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping
    public String rejestracja (Model model){
        return "";

    }
    @PostMapping
    public String rejestracjaAkcja (Model model){
        return "";
    }
}
