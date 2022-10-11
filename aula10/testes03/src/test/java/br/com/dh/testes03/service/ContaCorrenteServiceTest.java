package br.com.dh.testes03.service;

import br.com.dh.testes03.dao.ContaDAO;
import br.com.dh.testes03.exception.ContaInexistenteException;
import br.com.dh.testes03.exception.InvalidNumberException;
import br.com.dh.testes03.modelo.ContaCorrente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ContaCorrenteServiceTest {

    @InjectMocks
    private ContaCorrenteService service;

    @Mock
    private ContaDAO dao;

    @Test
    @DisplayName("Valida nova conta corrente")
    void novaContaCorrente_retornaNovaContaCorrente_seSucesso() {
        String nomeCliente = "Cliente 1";
        int numeroConta = 1;

        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);

        Mockito.when(dao.novaContaCorrente(ArgumentMatchers.anyString()))
                .thenReturn(novaConta);

        ContaCorrente contaCorrente = service.novaContaCorrente(nomeCliente);
        assertThat(contaCorrente).isNotNull();
        assertThat(contaCorrente.getNumero()).isPositive();

    }

    @Test
    void getConta_retornaContaCorrente_seExistir() throws ContaInexistenteException {
        String nomeCliente = "Cliente 1";
        int numeroConta = 1;

        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);

        Mockito.when(dao.novaContaCorrente(ArgumentMatchers.anyString()))
                .thenReturn(novaConta);

        ContaCorrente contaEncontrada = service.getConta(numeroConta);

        assertThat(contaEncontrada).isNotNull();
        assertThat(contaEncontrada.getNumero()).isEqualTo(numeroConta);
        assertThat(contaEncontrada.getSaldo()).isZero();
    }

    @Test
    void getConta_lancaContaInexistenteException_seNaoExiste() throws ContaInexistenteException {
        int numeroContaInexistente = 9999;

        BDDMockito.given(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .willThrow(new ContaInexistenteException("Conta inexistente"));

        assertThrows(ContaInexistenteException.class, () -> {
            service.getConta(numeroContaInexistente);
        });
    }

    @Test
    void sacar_returnTrue_seContaExisteEValorValidoESaldoSuficiente() throws InvalidNumberException, ContaInexistenteException {
        String nomeCliente = "Cliente 1";
        int numeroConta = 1;
        final double valorOperacao = 100;

        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);
        novaConta.depositar(valorOperacao);

        Mockito.when(dao.novaContaCorrente(String.valueOf(ArgumentMatchers.anyInt())))
                .thenReturn(novaConta);
        Mockito.when(dao.novaContaCorrente(ArgumentMatchers.any()))
                .thenReturn(novaConta);

       boolean sucesso = service.sacar(numeroConta, valorOperacao);

        assertThat(sucesso).isTrue();
        assertThat(novaConta.getSaldo()).isZero();
    }

    @Test
    void sacar_lancaContaInexistenteException_quandoContaNaoExiste() throws ContaInexistenteException {
        int numeroContaInexistente = 999;
        double valorOpercao = 100;

        BDDMockito.given(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .willThrow(new ContaInexistenteException("Conta não existe"));

        assertThrows(ContaInexistenteException.class, () -> {
            service.sacar(numeroContaInexistente, valorOpercao);
        });

        verify(dao, never()).updateConta(ArgumentMatchers.any());
    }

    @Test
    void sacar_lancarInvalidNumberException_quandoValorOperacaoInvalido() throws ContaInexistenteException {
        final String nomeCliente = "Cliente 1";
        final int numeroConta = 1;
        final double valorOperacao = -100;

        ContaCorrente novaConta = new ContaCorrente(numeroConta, nomeCliente);

        Mockito.when(dao.getContaCorrente(ArgumentMatchers.anyInt()))
                .thenReturn(novaConta);

        assertThrows(InvalidNumberException.class, () -> {
            service.sacar(numeroConta, valorOperacao);
        });

        verify(dao, never()).updateConta(ArgumentMatchers.any());
    }
}
