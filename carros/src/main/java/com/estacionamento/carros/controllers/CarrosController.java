package com.estacionamento.carros.controllers;

import static com.estacionamento.carros.utils.CarroUtils.getCarroDTOfromCarroParamsDTO;

import com.estacionamento.carros.DTO.CarroDTO;
import com.estacionamento.carros.DTO.CarroParamsDTO;
import com.estacionamento.carros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CarrosController {

    private CarroService carroService;

    @Autowired
    public CarrosController(CarroService carroService) {
        this.carroService = carroService;
    }

    // Função POST para salvar carro
    @RequestMapping(method = RequestMethod.POST, path = "/carros/cadastrar")
    public ResponseEntity registrarCarro(@RequestBody CarroParamsDTO carroParamsDTO) {
        CarroDTO carroDTO = getCarroDTOfromCarroParamsDTO(carroParamsDTO);
        carroService.registrarCarro(carroDTO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Função GET para pegar todos os carros cadastrados
    @RequestMapping(method = RequestMethod.GET, path = "/carros")
    public ResponseEntity <List<CarroDTO>> findAll() {
        List<CarroDTO> carros = carroService.findAll();

        return ResponseEntity.ok().body(carros);
    }

    // Função GET para pegar todos os carros cadastrados
    @RequestMapping(method = RequestMethod.GET, path = "/carros/{id}")
    public ResponseEntity <Optional<CarroDTO>> findById(@PathVariable String id) {
        Optional<CarroDTO> carroDTO = carroService.findById(id);

        return ResponseEntity.ok().body(carroDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/carros/{id}")
    public ResponseEntity deleteCarro(@PathVariable String id) {
        carroService.deleteCarro(id);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/carros/{id}")
    public ResponseEntity updateCarro(@RequestBody CarroDTO carroDTO) {
        carroService.updateCarro(carroDTO);

        return ResponseEntity.ok().build();
    }
}
