package com.example.demo.controllers;
import com.example.demo.controllers.forms.RegisterForm;
import com.example.demo.controllers.entities.User;
import com.example.demo.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
public class UserController {

    private UserRepositories userRepositories;

    @Autowired
    public UserController(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @GetMapping("/register")
    public String rejestracja(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "rejestracja";
    }

    @PostMapping("/register")
    public String rejestracjaAkcja(Model model, @ModelAttribute @Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (registerForm.getPassword() == null || !registerForm.getPassword().equals(registerForm.getPassword2())) {
            bindingResult.rejectValue("password", "123", "Hasła w polach 1 oraz 2 muszą być takie same");
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(registerForm.getName());
        user.setLastname(registerForm.getLastName());
        user.setEmail(registerForm.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerForm.getPassword()));
        user.setGitHubLogin(registerForm.getGitHubLogin());
        user.setTelephone(registerForm.getTelephone());
        user.setActive(true);
        user.setRole("ROLE_USER");

        userRepositories.save(user);
        return "redirect:/profilkursanta";

    }
    @RequestMapping("/login")
        public String loginForm (){
        return "logowanie";
    }

    @GetMapping("/profilkursanta")
    public String profilKursanta (Authentication auth, Model model){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userRepositories.findOneByEmail(userDetails.getUsername());
        System.out.println(user);
        model.addAttribute("user", user);
        return "profilkursanta";
    }
}



