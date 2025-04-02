package com.example.todoSimples.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todoSimples.Models.User;
import com.example.todoSimples.repositories.TaskRepostory;
import com.example.todoSimples.repositories.UserRepostory;

@Service
public class UserService {

    @Autowired
    private UserRepostory userRepostory;

    @Autowired
    private TaskRepostory taskRepostory;

    public User findById(Long id){
        Optional<User> user = this.userRepostory.findById(id);

        return user.orElseThrow(()-> new RuntimeException(
            "Ususario nao encontrado id:"+ id + "Tipo:"+ User.class.getName()
        ));
    }


    @Transactional
    public User creatUser(User obj){
        obj.setId(null);
        obj = this.userRepostory.save(obj);
        this.taskRepostory.saveAll(obj.getTasks());
        return obj;
    }


    @Transactional
    public User updade(User obj){
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepostory.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.userRepostory.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Nao e possivel excluir ha entidades ralcionadas!");
        }
    }
    
}
