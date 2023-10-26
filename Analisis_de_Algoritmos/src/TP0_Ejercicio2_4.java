
import java.util.Random;
import java.util.Scanner;

public class TP0_Ejercicio2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAleatorio = random.nextInt(100) + 1; // Genera un número entre 1 y 100
        int intentos = 0;
        int numeroIngresado;

        System.out.println("Bienvenido al juego de adivinar el número!");
        System.out.println("Intenta adivinar el número entre 1 y 100.");

        do {
            System.out.print("Ingresa un número: ");
            numeroIngresado = scanner.nextInt();
            intentos++;

            if (numeroIngresado < numeroAleatorio) {
                System.out.println("El número a adivinar es mayor.");
            } else if (numeroIngresado > numeroAleatorio) {
                System.out.println("El número a adivinar es menor.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
            }

        } while (numeroIngresado != numeroAleatorio);

        scanner.close();
    }
}