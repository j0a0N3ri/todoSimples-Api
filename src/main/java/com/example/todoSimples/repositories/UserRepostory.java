package com.example.todoSimples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoSimples.Models.User;



@Repository
public interface UserRepostory extends JpaRepository< User , Long> {

    
    
}
