package com.testing01.aula09.calculadora;

public class Calculadora {

    public double soma(double n1, double n2) {
        return n1 + n2;
    }

    public double divisao(double n1, double n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }
}
