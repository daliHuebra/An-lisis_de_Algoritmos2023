
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 1. Entrada/Salida
1. Utilizando un archivo de entrada que contenga un texto con varias palabras y varias líneas de texto y uno o más espacios en blanco entre ellas, generar
sinEspacios.txt con el mismo texto pero eliminando todos los espacios en blanco.*/

public class TP0_Ejercicio1_1 {

    public static void main(String[] args) {
        String archivoEntrada = "D:\\Universidad\\Analisis de Algoritmo\\Proyectos\\tp0Ej1\\src\\main\\java\\tp0\\entrada.txt";
        String archivoSalidaSinEspacios = "D:\\Universidad\\Analisis de Algoritmo\\Proyectos\\tp0Ej1\\src\\main\\java\\tp0\\salidaSinEspacios.txt";
        String archivoSalidaLineasImpares = "D:\\Universidad\\Analisis de Algoritmo\\Proyectos\\tp0Ej1\\src\\main\\java\\tp0\\salidaLineasImpares.txt";
        
        
       

        generarArchivoSinEspacios(archivoEntrada, archivoSalidaSinEspacios);
        generarArchivoLineasImpares(archivoEntrada, archivoSalidaLineasImpares);
    }

    public static void generarArchivoSinEspacios(String archivoEntrada, String archivoSalida) {
        try {
            BufferedReader bufferLectura = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                String lineaSinEspacios = linea.replaceAll("\\s+", "");
                bufferEscritura.write(lineaSinEspacios);
                bufferEscritura.newLine();
            }

            bufferLectura.close();
            bufferEscritura.close();
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algún archivo.");
        }
    }

    public static void generarArchivoLineasImpares(String archivoEntrada, String archivoSalida) {
        try {
            BufferedReader bufferLectura = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter bufferEscritura = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            int numeroLinea = 1;
            while ((linea = bufferLectura.readLine()) != null) {
                if (numeroLinea % 2 == 1) {
                    bufferEscritura.write(linea);
                    bufferEscritura.newLine();
                }
                numeroLinea++;
            }

            bufferLectura.close();
            bufferEscritura.close();
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algún archivo.");
        }
    }
}