package com.example.demo.controllers.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

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
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String password2;
    @NotEmpty
    private String GitHubLogin;
    @NotEmpty
    @Pattern(regexp = "[0-9]{9}")
    private String telephone;

}
