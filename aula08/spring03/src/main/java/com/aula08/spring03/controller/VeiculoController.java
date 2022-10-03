package com.aula08.spring03.controller;

import com.aula08.spring03.exception.VeiculoNotFoundException;
import com.aula08.spring03.service.VeiculoService;
import com.aula08.spring03.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired // Injeção de dependência. O spring vai gerar o objeto, não new Service...
    private VeiculoService service;

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable String placa) {
        try {
            Veiculo veiculo = service.getVeiculo(placa);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (VeiculoNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
