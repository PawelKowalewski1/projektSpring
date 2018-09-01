package com.example.demo.controllers.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString(exclude = {"password", "password2"})
public class RegisterForm {

    @NotBlank(message = "Nie używaż znaków 'białych'")
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String password2;
    @NotEmpty
    private String GitHubLogin;
    @NotEmpty
    private String telephone;



}
