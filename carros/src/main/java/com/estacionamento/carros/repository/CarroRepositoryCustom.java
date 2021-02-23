package com.estacionamento.carros.repository;

import com.estacionamento.carros.domain.Carro;

import java.util.List;
import java.util.Map;

public interface CarroRepositoryCustom {

    List<Carro> searchWithFilters(Map<String, String> params);
}
