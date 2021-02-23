package com.estacionamento.carros.controllers;

import com.estacionamento.carros.domain.Carro;
import com.estacionamento.carros.DTO.CarroCreateDTO;
import com.estacionamento.carros.services.CarroService;
import com.estacionamento.carros.utils.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CarrosController {

    private CarroService carroService;

    @Autowired
    public CarrosController(CarroService carroService) {
        this.carroService = carroService;
    }

    // Função GET para pegar todos os carros cadastrados
    @RequestMapping(method = RequestMethod.GET, path = "/carros")
    public ResponseEntity <List<Carro>> findAll() {
        List<Carro> carros = carroService.findAll();

        return ResponseEntity.ok().body(carros);
    }

    // Função GET para pegar todos os carros cadastrados
    @RequestMapping(method = RequestMethod.GET, path = "/carros/{id}")
    public ResponseEntity <Carro> findById(@PathVariable String id) {
        Carro carro = carroService.findById(id);

        return ResponseEntity.ok().body(carro);
    }

    // Função GET com filtros
    @RequestMapping(method = RequestMethod.GET, path = "/carros/filtros")
    public ResponseEntity <List<Carro>> getCarros(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "modelo", required = false) String modelo,
            @RequestParam(value = "cor", required = false) String cor,
            @RequestParam(value = "ano", required = false) String ano,
            @RequestParam(value = "categoria", required = false) String categoria,
            @RequestParam(value = "combustivel", required = false) String combustivel,
            @RequestParam(value = "motor", required = false) String motor,
            @RequestParam(value = "placa", required = false) String placa,
            @RequestParam(value = "km", required = false) String km
    ) {
        Map<String, String> params = new HashMap<>();

        if (nome != null) {
            params.put("nome", nome);
        }

        if (modelo != null) {
            params.put("modelo", modelo);
        }

        if (cor != null) {
            params.put("cor", cor);
        }

        if (ano != null) {
            params.put("ano", ano);
        }

        if (categoria != null) {
            params.put("categoria", categoria);
        }

        if (combustivel != null) {
            params.put("combustivel", combustivel);
        }

        if (motor != null) {
            params.put("motor", motor);
        }

        if (placa != null) {
            params.put("placa", placa);
        }

        if (km != null) {
            params.put("km", km);
        }

        for (String key : params.keySet()) {
            params.put(key, URL.decodePram(params.get(key)));
        }

        List<Carro> carros = carroService.searchWithFilters(params);

        return ResponseEntity.ok().body(carros);
    }

    // Função POST para salvar carro
    @RequestMapping(method = RequestMethod.POST, path = "/carros/cadastrar")
    public ResponseEntity<Void> registrarCarro(@RequestBody CarroCreateDTO carroCreateDTO) {
        Carro carro = carroService.registrarCarro(carroCreateDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // Função DELETE para deletar carro
    @RequestMapping(method = RequestMethod.DELETE, path = "/carros/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable String id) {
        carroService.deleteCarro(id);

        return ResponseEntity.noContent().build();
    }

    // Função PUT para atualizar carro
    @RequestMapping(method = RequestMethod.PUT, path = "/carros/{id}")
    public ResponseEntity<Void> updateCarro(@RequestBody Carro carro) {
        carroService.updateCarro(carro);

        return ResponseEntity.noContent().build();
    }
}
