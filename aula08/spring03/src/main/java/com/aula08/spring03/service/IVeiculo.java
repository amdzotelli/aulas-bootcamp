package com.aula08.spring03.service;

import com.aula08.spring03.exception.VeiculoNotFoundException;
import com.aula08.spring03.model.Veiculo;

import java.util.List;

public interface IVeiculo {
    Veiculo getVeiculo(String placa) throws VeiculoNotFoundException;
    List<Veiculo> getAllVeiculos();
}
