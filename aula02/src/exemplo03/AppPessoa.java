package exemplo03;

public class AppPessoa {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Marcos");

        System.out.println(estudante.getNome());
        System.out.println(estudante);

        Pessoa p = new Estudante("João");
        System.out.println(p);
    }
}