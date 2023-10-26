package TPO_2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TPO2_2_Ejercicio6 {

	 public static void main(String[] args) {
	        int[] lista1 = {2, 5, 5, 5};
	        int[] lista2 = {2, 2, 3, 5, 5, 7};

	        List<Integer> elementosComunes = encontrarElementosComunes(lista1, lista2);

	        System.out.println("Elementos comunes: " + elementosComunes);
	 }
	 
	    public static List<Integer> encontrarElementosComunes(int[] lista1, int[] lista2) {
	        List<Integer> elementosComunes = new ArrayList<>();
	        int i = 0;
	        int j = 0;

	        while (i < lista1.length && j < lista2.length) {
	            if (lista1[i] == lista2[j]) {
	                elementosComunes.add(lista1[i]);
	                i++;
	                j++;
	            } else if (lista1[i] < lista2[j]) {
	                i++;
	            } else {
	                j++;
	            }
	        }

	        return elementosComunes;
	    }
}