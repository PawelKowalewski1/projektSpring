package com.example.demo.controllers.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String GitHubLogin;
    private String telephone;
    private Long sqlOcena;
    private String sqlOpis;
    private Long pyOcena;
    private String pyOpis;
    private Long javaOcena;
    private String javaOpis;
    private Long springOcena;
    private String springOpis;
    private String role;


    @Column(name="enabled")
    private Boolean active;


}
