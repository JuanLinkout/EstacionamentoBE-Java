package com.estacionamento.carros.services;

import com.estacionamento.carros.DTO.CarroDTO;
import com.estacionamento.carros.DTO.CarroParamsDTO;
import com.estacionamento.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    // Função usada para registrar um novo carro.
    public void registrarCarro(CarroDTO carroDTO) {
        carroRepository.insert(carroDTO);
    }

    // Função GET para pegar todos os carros.
    public List<CarroDTO> findAll() {
        return carroRepository.findAll();
    }

    public Optional<CarroDTO> findById(String id) {
        Optional<CarroDTO> carroDTO = carroRepository.findById(id);
        return carroDTO;
    }

    public void deleteCarro(String id) {
        carroRepository.deleteById(id);
    }

    public void updateCarro(CarroDTO carroDTO) {
        carroRepository.save(carroDTO);
    }
}
