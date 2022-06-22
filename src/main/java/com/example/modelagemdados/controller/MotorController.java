package com.example.modelagemdados.controller;

import com.example.modelagemdados.entity.MotorEntity;
import com.example.modelagemdados.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("motores")
public class MotorController {

    @Autowired
    private MotorRepository repository;

    @PostMapping
    public MotorEntity save(@RequestBody MotorEntity entity) {
        return repository.save(entity);
    }
}
