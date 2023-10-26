package TPO_4_1;

import java.util.ArrayList;
import java.util.List;

public class Ejer2c {

	public static void main(String[] args) {

		long numero= 600851475143; //13195;
		int divisor=2; 
        ArrayList<Integer> factoresPrimosObtenidos = new ArrayList<>();
        
        System.out.println("Número a evaluar: " + numero);

        calcularFactoresPrimos(numero,divisor,factoresPrimosObtenidos);
        
        System.out.print("Los factores primos de: " + numero + "son: ");

        for (int i = 0; i < factoresPrimosObtenidos.size(); i++) {
            System.out.print(factoresPrimosObtenidos.get(i) + "-");
        }
        
        
        int maximo = 0; 

        for (int i = 0; i < factoresPrimosObtenidos.size(); i++) {
            if (factoresPrimosObtenidos.get(i) > maximo) {
                maximo = factoresPrimosObtenidos.get(i);
            }
        }
        
        System.out.println("\nEL FACTOR PRIMO MÁS GRANDE ES " + maximo);

 }
	
	public static void calcularFactoresPrimos(long numero, int divisor, ArrayList<Integer> factoresPrimosObtenidos) {
		/*Método recursivo para calcular los factores primos de un número */
		
		if (numero <=1) {
			return;
		}
		if (numero % divisor ==0 ) {
			factoresPrimosObtenidos.add(divisor);
			calcularFactoresPrimos( numero/divisor, divisor, factoresPrimosObtenidos);
		}else {
			calcularFactoresPrimos(numero, divisor+1, factoresPrimosObtenidos);

		}		
	}
}
