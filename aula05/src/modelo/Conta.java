package modelo;

import exception.InvalidNumberException;

public abstract class Conta {
    private int numero;
    private double saldo;
    private Cliente cliente;
    // referencia para uma classe dentro de outra classe
    // o cuidado: sempre garantir que esse objeto vai existir

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) throws InvalidNumberException {
        if (valor <= 0) {
            throw new InvalidNumberException("O valor não pode ser menor ou igual a 0");
        }
        saldo += valor;
    }

    public boolean sacar(double valor) throws InvalidNumberException {
        if (valor <= 0) {
            throw new InvalidNumberException("O valor não pode ser menor ou igual a 0");
        }
        saldo -= valor;
        return true;
    }

    @Override
    public String toString() {
        return "numero= " + numero +
                ", saldo= " + saldo +
                ", cliente= " + cliente;
    }

}
