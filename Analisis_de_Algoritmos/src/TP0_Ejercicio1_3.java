import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

/* 1.Entrada/Salida
 3.Generar un archivo de texto que contenga 100 números reales (double o float)
generados aleatoriamente con valores entre -100 y 100. */
public class TP0_Ejercicio1_3 {
     static final int CANTNUMEROS = 100;
    static final int MIN_VALOR = -100;
    static final int MAX_VALOR = 100;


    public static void main(String[] args) {
        String archivoSalida = "D:\\Universidad\\Analisis de Algoritmo\\Proyectos\\tp0Ej1\\src\\main\\java\\ejercicios\\numerosAleatorios.txt"; // Ruta del archivo de salida
        // Redondear a dos decimales
        DecimalFormat df = new DecimalFormat("#.##");
        
        try {
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(archivoSalida));
            Random generador = new Random();

            for (int i = 0; i < CANTNUMEROS; i++) {
                double numero = (MIN_VALOR + (generador.nextDouble() * (MAX_VALOR - MIN_VALOR))); // Generar número entre -100 y 100
                bufferEscritura.write(df.format(numero));
                bufferEscritura.newLine(); // Agregar nueva línea después de cada número
            }

            bufferEscritura.close();

            System.out.println("Archivo numerosAleatorios.txt generado exitosamente.");
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
            ex.printStackTrace();
        }
    }
}