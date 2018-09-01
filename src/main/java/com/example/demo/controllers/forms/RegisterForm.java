package com.example.demo.controllers.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.validation.constraints.*;

@Setter
@Getter
@ToString(exclude = {"password", "password2"})
public class RegisterForm {

    @NotBlank(message = "Nie używaż znaków 'białych'")
    @NotEmpty
    private String name;
    @NotEmpty(message = "Pole musi być uzupełnione")
    private String lastName;
    @NotEmpty(message = "Pole musi być uzupełnione")
    @Email(message = "mail jest niepoprawny lub istnieje w bazie")
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "Pole musi być uzupełnione")
    private String password;
    @NotEmpty(message = "Pole musi być uzupełnione")
    private String password2;
    @NotEmpty(message = "Pole musi być uzupełnione")
    private String GitHubLogin;
    @NotEmpty
    @Pattern(regexp = "[0-9]{9}", message = "Format numeru powinien składać się wyłącznie z 9-ciu cyfr pisanych łącznie")
    private String telephone;

}
