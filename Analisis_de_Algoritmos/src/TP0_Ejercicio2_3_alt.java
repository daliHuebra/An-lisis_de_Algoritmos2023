
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import utiles.TecladoIn;

public class TP0_Ejercicio2_3_alt {
    static final String OUTPUT_FILE_PATH = "src/tp0/output_files/prime_numbers.txt";

    public static void main(String[] args) throws Exception {
        System.out.println("CÁLCULO DE NÚMERO PRIMOS");
        System.out.print("Ingrese el límite: ");

        int max = TecladoIn.readInt();

        primes(max);
    }

    private static void primes(int max) {
        try {
            boolean[] noPrimes;
            int n, i, mul, q = 0;
            String out = "";
            int limit;

            if (max >= 2) {
                noPrimes = new boolean[max + 1];
                limit = (int) Math.sqrt(max);
                n = 2;
                while (n <= limit) {
                    if (!noPrimes[n]) {
                        q++;
                        out += " " + n;
                        i = 2;
                        mul = n * i;
                        while (mul <= max) {
                            noPrimes[mul] = true;
                            i++;
                            mul = n * i;
                        }
                    }
                    n++;
                }
                while (n < noPrimes.length) {
                    if (!noPrimes[n]) {
                        q++;
                        out += " " + n;
                    }
                    n++;
                }
            }
            System.out.println();
            System.out.print("Cantidad de número primos: " + q);
            System.out.println();
            System.out.println();
            System.out.println("Números primos: " + out);

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