package com.aula08.spring03.service;

import com.aula08.spring03.exception.NotFoundException;
import com.aula08.spring03.model.Veiculo;

import java.util.List;

public interface IVeiculo {
    Veiculo getVeiculo(String placa) throws NotFoundException;
    List<Veiculo> getAllVeiculos();
    List<Veiculo> getAllOrdersByValue();
    void save(Veiculo veiculo);
    List<Veiculo> getByModel(String model);
}
