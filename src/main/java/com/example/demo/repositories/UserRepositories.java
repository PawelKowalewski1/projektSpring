package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Integer> {
}
