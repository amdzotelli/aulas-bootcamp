package exemplo01;

public class AppLivro {
    // main -> ponto de ínicio do programa
    public static void main(String[] args) {
        // quando eu faço esse definição eu não estou iniciando a classe, diferente do tipo primitivo
        // exemplo: int numero, que já reserva um lugar na memória.
        // no objeto é preciso criar ele. Quando declara Livro tal nome, ele não é um tipo primitivo, é uma classe
        // ao definir o livro, cria uma separação no espaço na memória, mas vazio.

        Livro meuLivro;

        // aqui se cria um objeto com os atributos da classe, ex titulo e autor, tem isso na memória
        // porém, é outro espaço na memória, diferente da variável meuLivro criado na linha 11.
        // o meuLivro vai ser uma referência ao objeto, onde ele está

        meuLivro = new Livro();

        // É possível inicializar na mesma linha.

        meuLivro.titulo = "Programando em Java";

        // Alocação dinâmica. Feita durante a execução do programa
        // diferente do int n = tal que já inicia com o programa.
        System.out.println(meuLivro.titulo);
    }
}
