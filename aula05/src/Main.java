import data.GerenciaContas;
import exception.InvalidAccountException;
import modelo.Cliente;
import util.Imprimir;
import util.ImprimirTela;

public class Main {
    private static GerenciaContas contas = new GerenciaContas();

    public static void main(String[] args) {

        contas.novaContaCorrente(new Cliente());
        contas.novaContaCorrente(new Cliente());
        contas.novaContaPoupanca(new Cliente());

        try {
            contas.depositar(1, 100);
            contas.transferir(1, 2, 50);

            Imprimir saida = new ImprimirTela();
            saida.imprimir(contas.listarContas().toString());

            System.out.println(contas.listarContaCorrentePorNumero());
        } catch (Exception e)  {
            System.out.println("Erro");
        }

    }
}