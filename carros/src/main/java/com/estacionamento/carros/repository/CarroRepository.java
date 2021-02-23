package com.estacionamento.carros.repository;

import com.estacionamento.carros.domain.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "carros")
public interface CarroRepository extends MongoRepository<Carro, String>, CarroRepositoryCustom {}