
public class TP0_Ejercicio2_8_alt {
	
	public static int cant_alumnos = 4;
    public static int cant_asignaturas = 5;

	public static void main(String[] args) {
        
        double[][] notas = new double[cant_alumnos][cant_asignaturas];     
              
        //Carga de Notas fija (para pruebas)
        notas[0][0] = 9;
        notas[0][1] = 4;
        notas[0][2] = 0;
        notas[0][3] = 7;
        notas[0][4] = 2;
        
        notas[1][0] = 6;
        notas[1][1] = 4;
        notas[1][2] = 8;
        notas[1][3] = 0;
        notas[1][4] = 2;
        
        notas[2][0] = 4;
        notas[2][1] = 10;
        notas[2][2] = 8;
        notas[2][3] = 9;
        notas[2][4] = 4;
        
        notas[3][0] = 2;
        notas[3][1] = 4;
        notas[3][2] = 6;
        notas[3][3] = 4;
        notas[3][4] = 0;
        
        double[] mediaPorAlumno = new double[cant_alumnos];
        CalculoMediaPorAlumno(notas, mediaPorAlumno);
             
        double[] mediaPorAsignatura = new double[cant_asignaturas];
        CalculoMediaPorAsignatura(notas, mediaPorAsignatura);
        
        CalculoMediaTotalClase(notas, mediaPorAsignatura);
	
	}
	
	public static void CalculoMediaPorAlumno(double[][] notas, double[] mediaPorAlumno){
    	
    	for (int i = 0; i < cant_alumnos; i++) {
	        double sumatoria = 0;
	        for (int j = 0; j < cant_asignaturas; j++) {
	        	sumatoria += notas[i][j];
	        }
	        mediaPorAlumno[i] = sumatoria / cant_asignaturas;
	        System.out.println("La media del alumno/a " + (i) + " es: " + mediaPorAlumno[i]);
	    }
    }    

    public static void CalculoMediaPorAsignatura(double[][] notas, double[] mediaPorAsignatura){
	    
    	for (int j = 0; j < cant_asignaturas; j++) {
	        double sumatoria = 0;
	        for (int i = 0; i < cant_alumnos; i++) {
	        	sumatoria += notas[i][j];
	        }
	        mediaPorAsignatura[j] = sumatoria / cant_alumnos;
	        System.out.println("La media de la asignatura " + (j) + " es: " + mediaPorAsignatura[j]);
	    }
    }
    
    public static void CalculoMediaTotalClase(double[][] notas, double[] mediaPorAsignatura){
	    double sumaTotal = 0;
	    
	    for (int i = 0; i < cant_alumnos; i++) {
	        for (int j = 0; j < cant_asignaturas; j++) {
	            sumaTotal += notas[i][j];
	        }
	    }
	    
	    double mediaTotalClase = sumaTotal / (cant_alumnos * cant_asignaturas);
	    System.out.println("La media total de la clase es: " + mediaTotalClase);
    }

}