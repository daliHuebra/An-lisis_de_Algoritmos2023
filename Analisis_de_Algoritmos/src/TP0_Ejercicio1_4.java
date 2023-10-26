
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/* 1.Entrada/Salida
 * 4.Generar un archivo de texto con cadenas aleatorias de 10 caracteres alfanuméricos
(0-9, a-z, ́ A-Z). */

public class TP0_Ejercicio1_4 {

    public static void main(String[] args) {
        String archivoSalida = "D:\\Universidad\\Analisis de Algoritmo\\Proyectos\\tp0Ej1\\src\\main\\java\\ejercicios\\cadenasAleatorias.txt";

        // Definimos la longitud de cada cadena aleatoria
        int longitudCadena = 10;

        // Definimos los caracteres permitidos para las cadenas aleatorias (alfanuméricos)
        String caracteresPermitidos = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        try {
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(archivoSalida));
            Random generador = new Random();
            for (int i = 0; i < 100; i++) {
                // Creamos un StringBuilder para construir cada cadena aleatoria
                StringBuilder cadenaAleatoria = new StringBuilder();

                // Generamos cada caracter de la cadena aleatoria
                for (int j = 0; j < longitudCadena; j++) {
                    // Elegimos un índice aleatorio para seleccionar un caracter permitido
                    int indiceCaracter = generador.nextInt(caracteresPermitidos.length());

                    // Obtenemos el caracter aleatorio correspondiente al índice
                    char caracterAleatorio = caracteresPermitidos.charAt(indiceCaracter);

                    // Agregamos el caracter a la cadena aleatoria en construcción
                    cadenaAleatoria.append(caracterAleatorio);
                }

                // Escribimos la cadena aleatoria en el archivo de salida
                bufferEscritura.write(cadenaAleatoria.toString());
                bufferEscritura.newLine(); 
            }

            bufferEscritura.close();
            System.out.println("Archivo cadenasAleatorias.txt generado exitosamente.");
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
            ex.printStackTrace();
        }
    }
}