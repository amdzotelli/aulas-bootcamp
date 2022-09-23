package exemplo02;

public class Relogio {
    // classe com representação dos atributos
    private int hora, minuto, segundo;
    // esconde os atributos e permite que os métodos sejam visualizados

    public Relogio() {}


    public Relogio(int hora, int minuto, int segundo) {
        // método construtor, pode ter parâmetros ou não, construtor default
        setHora(hora);
        setMinuto(minuto);
        this.segundo = segundo;
    }

    // métodos -> ações
    // tem [retorno] nome (possivelmente parâmetros) e {}
    // sem retorno, usa palavra reservada void

    public void setHora(int novaHora) {
        if (novaHora >= 0 && novaHora < 24) {
            this.hora = novaHora;
        }
    }

    public void setMinuto(int novoMinuto) {
        if (novoMinuto >= 0 && novoMinuto <= 60) {
            this.minuto = novoMinuto;
        }
    }

    public void getHorario() {
        System.out.println("Hora atual: " + hora + ":" + minuto + ":" + segundo);
    }

    public void getHora() {
        System.out.println(hora);
    }
}
