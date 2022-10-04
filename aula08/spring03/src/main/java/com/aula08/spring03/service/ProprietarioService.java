package com.aula08.spring03.service;

import com.aula08.spring03.model.Proprietario;
import com.aula08.spring03.model.Veiculo;
import com.aula08.spring03.repository.ProprietarioRepository;
import com.aula08.spring03.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProprietarioService implements IProprietario{

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Override
    public List<Proprietario> getAll() {
        List<Veiculo> veiculoList = new ArrayList<>(veiculoRepository.getAll());
        List<Proprietario> proprietarioList = new ArrayList<>(proprietarioRepository.getAll());

        proprietarioList.forEach(proprietario -> {
                    List<Veiculo> veiculosDoProp = veiculoList.stream()
                            .filter(v->v.getId_proprietario()== proprietario.getId())
                            .collect(Collectors.toList());
                    proprietario.setVeiculos( veiculosDoProp );
                    veiculoList.removeAll(veiculosDoProp);
                });

        return proprietarioList;
    }
}