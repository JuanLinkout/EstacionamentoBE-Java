package com.estacionamento.carros.utils;

import com.estacionamento.carros.DTO.CarroDTO;
import com.estacionamento.carros.DTO.CarroParamsDTO;

public class CarroUtils {

    public static CarroDTO getCarroDTOfromCarroParamsDTO(CarroParamsDTO carroParamsDTO) {
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setPlaca(carroParamsDTO.getPlaca());
        carroDTO.setNome(carroParamsDTO.getNome());
        carroDTO.setMotor(carroParamsDTO.getMotor());
        carroDTO.setModelo(carroParamsDTO.getModelo());
        carroDTO.setCor(carroParamsDTO.getCor());
        carroDTO.setAno(carroParamsDTO.getAno());
        carroDTO.setCategoria(carroParamsDTO.getCategoria());
        carroDTO.setKm(carroParamsDTO.getKm());
        carroDTO.setCombustivel(carroParamsDTO.getCombustivel());

        return carroDTO;
    }
}
