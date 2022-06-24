package com.example.modelagemdados.repository;

import com.example.modelagemdados.entity.ModeloEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<ModeloEntity, String> {
}
