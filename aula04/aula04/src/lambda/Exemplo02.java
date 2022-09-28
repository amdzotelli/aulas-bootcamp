package lambda;

import java.util.Arrays;
import java.util.List;

public class Exemplo02 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numeros.forEach( (n) -> System.out.print(n + " - "));

        for (int i = 0; i < numeros.size(); i++) {
            // for mais prático para acessar posição
            numeros.get(i);
        }

        for (Integer integer : numeros) { // foreach
            System.out.println(integer);
        }
    }
}
