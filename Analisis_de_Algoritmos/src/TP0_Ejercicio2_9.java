import java.util.Arrays;

public class TP0_Ejercicio2_9 {

	public static void main(String[] args) {
		int[] lista_A = cargarElementosLista(100);
        int[] lista_B = cargarElementosLista(60);

        System.out.println("Lista A original: " + Arrays.toString(lista_A));
        
        ordenarListaPorSeleccion(lista_A);
        
        System.out.println("Lista A ordenada: " + Arrays.toString(lista_A));
        
        System.out.println("Lista B original: " + Arrays.toString(lista_B));
        
        ordenarListaPorBurbuja(lista_B);
        
        System.out.println("Lista B ordenada: " + Arrays.toString(lista_B));    

	
		mezclarListasOrdenadas(lista_A,lista_B);
		
	}
		    
    public static int[] cargarElementosLista(int cant) {
        
    	int[] listaGenerada = new int[cant];
        for (int i = 0; i < cant; i++) {
        	//carga elementos aleatorios de 0 a 999 
        	listaGenerada[i] = (int) (Math.random() * 1000); 
        }
        return listaGenerada;
    }

    public static void ordenarListaPorSeleccion(int[] lista) {
       
    	for (int i = 0; i < lista.length - 1; i++) {
            int i_menor = i;
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[i_menor]) {
                	i_menor = j;
                }
            }
            int temp = lista[i_menor];
            lista[i_menor] = lista[i];
            lista[i] = temp;
        }
    }
    
    public static void ordenarListaPorBurbuja(int[] lista) {
        
    	int n = lista.length;
    	
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }
    
    public static void mezclarListasOrdenadas(int[] lista_A, int[] lista_B) {
        int tamanoC = lista_A.length + lista_B.length;
        int[] lista_C = new int[tamanoC];

        int indiceA = 0;
        int indiceB = 0;

        for (int i = 0; i < tamanoC; i++) {
            if (indiceA < lista_A.length && (indiceB >= lista_B.length || lista_A[indiceA] < lista_B[indiceB])) {
            	lista_C[i] = lista_A[indiceA];
                indiceA++;
            } else {
            	lista_C[i] = lista_B[indiceB];
                indiceB++;
            }
        }

        System.out.println("Lista C mezclando Lista_A y Lista_B: " + Arrays.toString(lista_C));
        
    }
}