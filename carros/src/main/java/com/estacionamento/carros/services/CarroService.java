package com.estacionamento.carros.services;

import com.estacionamento.carros.DTO.CarroCreateDTO;
import com.estacionamento.carros.exception.ObjectNotFoundException;
import com.estacionamento.carros.domain.Carro;
import com.estacionamento.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.estacionamento.carros.utils.CarroUtils.getCarroFromCarroCreate;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    // Função GET para pegar todos os carros.
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    // Função GET para pegar um carro por ID.
    public Carro findById(String id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado."));
    }

    // Função usada para registrar um novo carro.
    public Carro registrarCarro(CarroCreateDTO carroCreateDTO) {
        Carro carro = getCarroFromCarroCreate(carroCreateDTO);
        return carroRepository.insert(carro);
    }

    // Função DELETE para deletar um carro.
    public void deleteCarro(String id) {
        // Procura o id antes, caso exista não faz nada e caso não exista joga uma exceção
        findById(id);
        carroRepository.deleteById(id);
    }

    // Função PUT para atualizar um carro.
    public void updateCarro(Carro carro) {
        // Se o objeto já possui  ID, o mongo faz a operação sozinho.
        carroRepository.save(carro);
    }

    public List<Carro> searchWithFilters(Map<String, String> params) {
        return carroRepository.searchWithFilters(params);
    }
}
