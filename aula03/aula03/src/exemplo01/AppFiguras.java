package exemplo01;

public class AppFiguras {

    public static void main(String[] args) {
        Quadrado q = new Quadrado(1,1);
        Figura f = new Quadrado(2,2);

        // Figura f2 = new Figura(3,4);
        // classe abstrata não pode ser instânciada.

        Figura vetorFigura[] = new Figura[3];

        vetorFigura[0] = new Quadrado(2,2);
        vetorFigura[1] = new Circulo(4,4);
        vetorFigura[2] = new Quadrado(2,2);


        for (int i = 0; i < 3; i++) {
            vetorFigura[i].exibir2();
        }

        q.exibir();

        GerarPdf.gerar(vetorFigura[0]);
        GerarPdf.gerar(vetorFigura[1]);
        GerarPdf.gerar(vetorFigura[2]);

        ExibirTela tela = new ExibirTela();
        vetorFigura[0].show(tela);

        ExibirImpressora impressora = new ExibirImpressora();

        vetorFigura[1].show(impressora);
    }
}
