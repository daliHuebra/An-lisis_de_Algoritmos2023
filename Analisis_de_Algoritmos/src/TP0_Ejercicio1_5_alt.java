
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import utiles.Aleatorio;

public class TP0_Ejercicio1_5_alt {
    static final String OUTPUT_FILE_PATH = "src/tp0/output_files/random_distinct_numbers.txt";
    static final int MAX_RANDOM_NUMBERS = 10;
    static final int MIN = 1;
    static final int MAX = 1000;

    public static void main(String[] args) throws Exception {
        random();
    }

    private static void random() {
        try {
            boolean[] nums = new boolean[1000];
            int i, num;
            String out = "";

            for (i = 0; i < MAX_RANDOM_NUMBERS; i++) {
                num = Aleatorio.intAleatorio(MIN, MAX);
                if (!nums[num]) {
                    nums[num] = true;
                    out += num + "\n";
                }
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