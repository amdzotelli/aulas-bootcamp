package com.aula08.spring03.service;

import com.aula08.spring03.dto.VeiculoDTO;
import com.aula08.spring03.exception.NotFoundException;
import com.aula08.spring03.model.Veiculo;
import com.aula08.spring03.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService implements IVeiculo {

    @Autowired
    private VeiculoRepository repository;
    @Override
    public Veiculo getVeiculo(String placa) throws NotFoundException {
        Optional<Veiculo> veiculo = repository.getVeiculo(placa);

        if(veiculo.isEmpty()) {
            throw new NotFoundException("Veiculo não encontrado.");
        }
        return veiculo.get();
    }

    @Override
    public List<VeiculoDTO> getAllVeiculos() {
        return repository.getAll().stream()
                // .map(v->new VeiculoDTO(v))
                .map(VeiculoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Veiculo> getAllOrdersByValue() {
        List<Veiculo> veiculos = repository.getAll();

        return veiculos.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public void save(Veiculo veiculo) {
        repository.saveVeiculo(veiculo);
    }

    @Override
    public List<Veiculo> getByModel(String model) {
        return getAllOrdersByValue().stream()
                .filter(v-> v.getModelo().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

}
