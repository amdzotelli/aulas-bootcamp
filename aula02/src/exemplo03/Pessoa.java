package exemplo03;

public class Pessoa {
    private String nome;

    // Overload: mesmo método, mas com diferentes parâmetros

    public Pessoa() {}

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override // Override: sobrescrever
    public String toString() {
        return nome;
    }
}
