package utils.input;

import java.util.Scanner;

/**
 *
 * @author danielborges93
 */
public class Leitor {

    /**
     * Lê uma linha digitada pelo teclado.
     *
     * @return Retorna a string da linha digitada.
     */
    public static String lerLinha() {

        // Ler a liha digitada
        Scanner scanner = new Scanner(System.in);
        String linha = scanner.nextLine();

        // Retornar
        return linha;
    }

}
