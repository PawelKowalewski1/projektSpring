package com.example.demo.controllers;
import com.example.demo.controllers.forms.RegisterForm;
import com.example.demo.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (!registerForm.getEmail().contains("@")) {
            bindingResult.rejectValue("email", "234", "Podaj prawdziwy adres email");
        }
        return "register";
    }
}