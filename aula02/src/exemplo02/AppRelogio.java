package exemplo02;

public class AppRelogio {
    // método

    // instâncias das classes
    public static void main(String[] args) {
        Relogio meuRelogio = new Relogio(9, 12, 0);
        Relogio outroRelogio = new Relogio();

        outroRelogio.setHora(12);
        outroRelogio.setMinuto(25);

        meuRelogio.getHorario();
        outroRelogio.getHorario();

        meuRelogio.getHora();

    }
}
