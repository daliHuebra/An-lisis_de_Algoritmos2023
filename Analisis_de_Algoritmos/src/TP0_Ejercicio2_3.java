
import java.util.Scanner;

public class TP0_Ejercicio2_3 {

    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un número n: ");
        int n = scanner.nextInt();
        
        // Consumir la nueva línea en blanco
        scanner.nextLine();
        int cantidadPrimos = 0;
        for (int i = 1; i <= n; i++) {
            if (esPrimo(i)) {
                cantidadPrimos++;
            }
        }

        System.out.println("Cantidad de números primos entre 1 y " + n + ": " + cantidadPrimos);
    }
}