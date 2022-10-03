package com.aula08.spring03.service;

import com.aula08.spring03.exception.VeiculoNotFoundException;
import com.aula08.spring03.model.Veiculo;
import com.aula08.spring03.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService implements IVeiculo{

    @Autowired
    private VeiculoRepository repository;
    @Override
    public Veiculo getVeiculo(String placa) throws VeiculoNotFoundException {
        Optional<Veiculo> veiculo = repository.getVeiculo(placa);

        if(veiculo.isEmpty()) {
            throw new VeiculoNotFoundException("Veiculo não encontrado.");
        }
        return veiculo.get();
    }

    @Override
    public List<Veiculo> getAllVeiculos() {
        return null;
    }
}
