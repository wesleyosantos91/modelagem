package com.example.modelagemdados.controller;

import com.example.modelagemdados.entity.ModeloEntity;
import com.example.modelagemdados.repository.ModeloRepository;
import com.example.modelagemdados.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository repository;

    @Autowired
    private MotorRepository motorRepository;

    @Transactional
    @PostMapping
    public ModeloEntity save(@RequestBody ModeloEntity entity) {
        entity.getParametros().forEach(p -> {
            p.setModelo(entity);
        });
        entity.getMotores().forEach(m-> {
            m.setModelo(entity);
            m.getId().setCodigoIdentificadorCanal(1);
            m.setMotor(motorRepository.findById(m.getMotor().getCodigoIdentificador()).get());
        });
        ModeloEntity save = repository.save(entity);

        System.out.println(save);

        return null;
    }
}
