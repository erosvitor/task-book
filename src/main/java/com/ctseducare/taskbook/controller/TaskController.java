package com.ctseducare.taskbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctseducare.taskbook.model.Task;
import com.ctseducare.taskbook.service.TaskService;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    TaskService service;
    
    @PostMapping(consumes = { "application/json", "application/xml", "application/x-yaml" }, produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<Task> insert(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(service.insert(task));
    }
    
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping(consumes = { "application/json", "application/xml", "application/x-yaml" }, produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<Task> update(@RequestBody Task task) {
        return ResponseEntity.ok(service.update(task));
    }
    
    @DeleteMapping(path = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("Item excluído");
    }
    
}
