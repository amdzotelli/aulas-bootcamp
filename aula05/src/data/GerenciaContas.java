package data;

import exception.InvalidAccountException;
import exception.InvalidNumberException;
import modelo.*;
import util.NumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciaContas {
    private Map<Integer, Conta> contas;
    NumberGenerator numberGenerator;

    public GerenciaContas() {
        contas = new HashMap<>();
        numberGenerator = NumberGenerator.getInstance();
    }

    public void novaContaCorrente(Cliente cliente) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaCorrente(numeroConta, cliente));
    }

    public void novaContaEspecial(Cliente cliente, double limite) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaEspecial(numeroConta, cliente, limite));
    }

    public void novaContaPoupanca(Cliente cliente) {
        int numeroConta = numberGenerator.getNext();
        contas.put(numeroConta, new ContaPoupanca(numeroConta, cliente));
    }

    public void depositar(int numeroConta, double valor) throws InvalidAccountException, InvalidNumberException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new InvalidAccountException("Conta não encontrada");
        }
        conta.depositar(valor);
    }

    public boolean sacar(int numeroConta, double valor) throws InvalidAccountException, InvalidNumberException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new InvalidAccountException("Conta não encontrada");
        }
        return conta.sacar(valor);
    }

    public String obterDadosConta(int numeroConta) throws InvalidAccountException {
    Conta conta = contas.get(numeroConta);
    if (conta == null) {
        throw new InvalidAccountException("Conta não encontrada");
    }
    return conta.toString();
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws InvalidAccountException, InvalidNumberException {
        Conta contaOrigem = contas.get(numeroContaOrigem);
        Conta contaDestino = contas.get(numeroContaDestino);
        if (contaOrigem == null || contaDestino == null) {
            throw new InvalidAccountException("Conta não encontrada");
        }
        boolean saqueRealizado = contaOrigem.sacar(valor);

        if (saqueRealizado) {
            contaDestino.depositar(valor);
        }
    }

    public List<String> listarContas() {
        return contas.values()
                .stream()
                .map(conta -> conta.toString() + "\n")
                .collect(Collectors.toList());
    }

    public List<String> listarContaCorrentePorNumero() {
        return contas.values()
                .stream()
                .filter(conta -> conta instanceof ContaCorrente)
                .sorted((a, b) -> a.getNumero() - b.getNumero())
                .map(conta -> conta.toString())
                .collect(Collectors.toList());
    }
}
