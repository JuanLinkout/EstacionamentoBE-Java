package com.estacionamento.carros.repository;

import com.estacionamento.carros.DTO.CarroDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends MongoRepository<CarroDTO, String> {}
