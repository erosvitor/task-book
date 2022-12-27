package com.ctseducare.taskbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctseducare.taskbook.exception.ResourceNotFoundException;
import com.ctseducare.taskbook.model.Task;
import com.ctseducare.taskbook.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;
    
    public Task insert(Task task) {
        return repository.save(task);
    }
    
    public List<Task> findAll() {
        return repository.findAll();
    }
    
    public Task update(Task task) {
        repository
          .findById(task.getId())
          .orElseThrow(() -> new ResourceNotFoundException("Task does not exist!"));
        return repository.save(task);
    }
    
    public void delete(Integer id) {
        repository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Task does not exist!"));
        repository.deleteById(id);
    }
    
}
