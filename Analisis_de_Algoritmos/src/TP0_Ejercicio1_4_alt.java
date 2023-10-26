
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import utiles.Aleatorio;

/* 1.Entrada/Salida
 * 4.Generar un archivo de texto con cadenas aleatorias de 10 caracteres alfanuméricos
(0-9, a-z, ́ A-Z). */

public class TP0_Ejercicio1_4_alt {
    static final String OUTPUT_FILE_PATH = "src/tp0/output_files/random_characters.txt";
    static final int CHAR_QUANTITY = 10;
    static final int STRING_QUANTITY = 10;

    public static void main(String[] args) throws Exception {
        random();
    }

    private static void random() {
        try {
            int i, j;
            int opt;
            String out = "";

            for (i = 0; i < STRING_QUANTITY; i++) {
                for (j = 0; j < CHAR_QUANTITY; j++) {
                    opt = Aleatorio.intAleatorio(1, 3);

                    if (opt == 1) {
                        out += Aleatorio.intAleatorio(0, 9);
                    } else if (opt == 2) {
                        out += (char) Aleatorio.intAleatorio(65, 90);
                    } else {
                        out += (char) Aleatorio.intAleatorio(97, 122);
                    }
                }
                out += "\n";
            }

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH));
            buffWriter.write(out);
            buffWriter.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo de entrada no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}