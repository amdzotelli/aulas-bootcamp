package com.aula08.spring03.controller;

import com.aula08.spring03.service.IVeiculo;
import com.aula08.spring03.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired // Injeção de dependência. O spring vai gerar o objeto, não new Service...
    private IVeiculo service;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        Veiculo veiculo = service.getVeiculo(placa);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll() {
        return new ResponseEntity<>(service.getAllVeiculos(), HttpStatus.OK);
    }

    @GetMapping("/sortedvalue")
    public ResponseEntity<List<Veiculo>> getAllOrdersByValue() {
        return new ResponseEntity<>(service.getAllOrdersByValue(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Veiculo veiculo) {
        service.save(veiculo);
    }
}
