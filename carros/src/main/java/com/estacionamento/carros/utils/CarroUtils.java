package com.estacionamento.carros.utils;

import com.estacionamento.carros.domain.Carro;
import com.estacionamento.carros.DTO.CarroCreateDTO;

public class CarroUtils {

    public static Carro getCarroFromCarroCreate(CarroCreateDTO carroCreateDTO) {
        Carro carro = new Carro();
        carro.setPlaca(carroCreateDTO.getPlaca());
        carro.setNome(carroCreateDTO.getNome());
        carro.setMotor(carroCreateDTO.getMotor());
        carro.setModelo(carroCreateDTO.getModelo());
        carro.setCor(carroCreateDTO.getCor());
        carro.setAno(carroCreateDTO.getAno());
        carro.setCategoria(carroCreateDTO.getCategoria());
        carro.setKm(carroCreateDTO.getKm());
        carro.setCombustivel(carroCreateDTO.getCombustivel());

        return carro;
    }
}
