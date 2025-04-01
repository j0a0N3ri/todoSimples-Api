package com.example.todoSimples.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoSimples.Models.Task;

@Repository
public interface TaskRepostory extends JpaRepository<Task , Long >{
    
    List<Task> findByUser_id(long id);

    //@Query(value = "SELECT t FROM Task t WHERE t.user.id =:id")
    //List<Task> findByUser_id(@Param("id") long id);

    //@Query(value = "SELECT * FROM Task t WHERE user_id =:id" , nativeQuery = true) 
    //List<Task> findByUser_id(@Param("id") long id);

}
