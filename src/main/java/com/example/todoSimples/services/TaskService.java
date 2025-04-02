package com.example.todoSimples.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todoSimples.Models.Task;
import com.example.todoSimples.Models.User;
import com.example.todoSimples.repositories.TaskRepostory;

@Service
public class TaskService {
   
    @Autowired
    private TaskRepostory taskRepostory;

    @Autowired
    private UserService userService;

    public Task findById(Long id){

        Optional<Task> task = this.taskRepostory.findById(id);

        return task.orElseThrow(() -> new RuntimeException("Task nao encontrada! Id:"+ id +"Tipo:" + Task.class.getName()));

    }

    @Transactional
    public Task create(Task obj){
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepostory.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepostory.save(newObj);
    }

    @Transactional
    public void delete(Long id){
        findById(id);
        try {
            this.taskRepostory.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Nao e possivel excluir ha entidades ralcionadas!");
        }
    }

}
