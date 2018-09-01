package com.example.demo.repositories;


import com.example.demo.controllers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User,Integer> {
    User findOneByEmail(String email);
}
