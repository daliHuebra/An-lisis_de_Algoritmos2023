
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TP0_Ejercicio1_5 {

    public static void main(String[] args) {
        String archivoSalida = "D:\\Universidad\\Analisis de Algoritmo\\Proyectos\\tp0Ej1\\src\\main\\java\\ejercicios\\numerosSinRepeticion.txt"; // Ruta del archivo de salida
        int cantidadNumeros = 1000; // Cantidad total de números
        int rangoNumeros = 1000; // Rango de números del 1 al 1000

        try {
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(archivoSalida));
            Random generador = new Random();
            Set<Integer> numerosGenerados = new HashSet<>(); // Conjunto para evitar repeticiones

            // Generamos números hasta alcanzar la cantidad deseada
            while (numerosGenerados.size() < cantidadNumeros) {
                int numeroAleatorio = generador.nextInt(rangoNumeros) + 1; // Generar número del 1 al 1000

                // Agregamos el número generado al conjunto si no está repetido
                if (numerosGenerados.add(numeroAleatorio)) {
                    bufferEscritura.write(Integer.toString(numeroAleatorio));
                    bufferEscritura.newLine(); 
                }
            }

            bufferEscritura.close();

            System.out.println("Archivo numerosSinRepeticion.txt generado exitosamente.");
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
            ex.printStackTrace();
        }
    }
}