package com.example.spring02.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private final int id;
    private final String nome;
    private final double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
}
