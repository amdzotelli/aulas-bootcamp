package com.aula08.spring03.dto;

import com.aula08.spring03.model.Veiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoDTO implements Serializable {
    private String placa;
    private String modelo;

    public VeiculoDTO(Veiculo veiculo) {
        this.placa= veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
    }
}
