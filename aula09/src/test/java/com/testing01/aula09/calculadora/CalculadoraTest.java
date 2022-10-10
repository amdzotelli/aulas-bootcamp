package com.testing01.aula09.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    Calculadora calculadora;

    @BeforeEach
    public void setup() {
        calculadora = new Calculadora();
    }

    // método_testado  o_que_é_esperado   dados_fornecidos
    @Test
    @DisplayName("Valida a soma")
    void soma_returnDouble_quandoInputValido() {
        // setup
        double n1 = 9;
        double n2 = 11;
        double resultadoEsperado = 20;

        // run
        double resultado = calculadora.soma(n1, n2);

        // validate
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Valida a divisão com números positivos")
    void divisao_returnDouble_quandoDoisNumerosPositivos() {
        // setup
        double n1 = 20;
        double n2 = 4;
        double resultadoEsperado = 5;
        // run
        double resultado = calculadora.divisao(n1, n2);
        // validate
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    @DisplayName("Valida a divisão com divisão por zero")
    void divisao_returnDouble_quandoDivisorZero() {
        // setup
        double n1 = 20;
        double n2 = 0;
        double resultadoEsperado = 0;
        // run
        double resultado = calculadora.divisao(n1, n2);
        // validate
        assertEquals(resultadoEsperado, resultado);
    }
}
