import utiles.Aleatorio;

class StudentAverage {
    String student;
    int averageNote;

    public StudentAverage(String student, int averageNote) {
        this.student = student;
        this.averageNote = averageNote;
    }
}

public class TP0_Ejercicio2_8 {
    static final String[] STUDENTS = new String[] { "Pepe", "Monica", "Paola", "Coqui", "Dardo", "Maria Elena" };
    static final String[] SUBJECTS = new String[] { "Matemática", "Química", "Lengua", "Historia", "Geografía" };

    public static void main(String[] args) throws Exception {
        int[][] notes = randomNotes();
        int[] averagesPerStudent;
        int[] averagesPerSubject;
        int averageClass;
        StudentAverage[] quickSort;
        StudentAverage[] bubbleSort;

        averagesPerStudent = calculateAveragePerStudent(notes);
        printAveragePerStudent(averagesPerStudent);

        averagesPerSubject = calculateAveragePerSubject(notes);
        printAveragePerSubject(averagesPerSubject);

        averageClass = calculateAverageClass(averagesPerStudent);
        printAverageClass(averageClass);

        bubbleSort = sortByBubbleSort(averagesPerStudent);
        printStudenAverageList(bubbleSort, "Bubble Sort");

        quickSort = sortByQuickSort(averagesPerStudent);
        printStudenAverageList(quickSort, "Quick Sort");
    }

    /**
     * @return Retorna una matriz donde las filas identifican al estudiante y las
     *         columnas a las materias.
     */
    private static int[][] randomNotes() {
        int[][] notes = new int[STUDENTS.length][SUBJECTS.length];

        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                notes[i][j] = Aleatorio.intAleatorio(0, 10);
            }
        }
        return notes;
    }

    private static int[] calculateAveragePerStudent(int[][] notes) {
        int[] averages = new int[notes.length];

        for (int i = 0; i < averages.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                averages[i] += notes[i][j];
            }
            averages[i] = averages[i] / notes[i].length;
        }

        return averages;
    }

    private static int[] calculateAveragePerSubject(int[][] notes) {
        int[] averages = new int[SUBJECTS.length];

        for (int i = 0; i < SUBJECTS.length; i++) {
            for (int j = 0; j < STUDENTS.length; j++) {
                averages[i] += notes[j][i];
            }
            averages[i] = averages[i] / SUBJECTS.length;
        }
        return averages;
    }

    private static int calculateAverageClass(int[] averagesPerStudent) {
        int average = 0;

        for (int i = 0; i < averagesPerStudent.length; i++) {
            average += averagesPerStudent[i];
        }
        return average / averagesPerStudent.length;
    }

    private static void printAveragePerStudent(int[] averages) {
        System.out.println("--------------------------------------------------");
        System.out.println("Media por estudiante");
        System.out.println();
        for (int i = 0; i < averages.length; i++) {
            System.out.println(STUDENTS[i] + ": " + averages[i]);
        }
        System.out.println();
    }

    private static void printAveragePerSubject(int[] averages) {
        System.out.println("--------------------------------------------------");
        System.out.println("Media por asignatura");
        System.out.println();
        for (int i = 0; i < averages.length; i++) {
            System.out.println(SUBJECTS[i] + ": " + averages[i]);
        }
        System.out.println();
    }

    private static void printAverageClass(int average) {
        System.out.println("--------------------------------------------------");
        System.out.println("Media de la clase");
        System.out.println();
        System.out.println("Media: " + average);
        System.out.println();
    }

    private static StudentAverage[] sortByBubbleSort(int[] averages) {

        StudentAverage[] list = new StudentAverage[averages.length];
        StudentAverage aux;
        int i, j;

        for (i = 0; i < list.length; i++) {
            list[i] = new StudentAverage(STUDENTS[i], averages[i]);
        }

        for (i = 0; i < list.length; i++) {

            for (j = 1; j <= list.length - 1; j++) {
                if (list[j - 1].averageNote < list[j].averageNote) {
                    aux = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = aux;
                }
            }
        }

        return list;
    }

    private static void printStudenAverageList(StudentAverage[] list, String title) {
        System.out.println("--------------------------------------------------");
        System.out.println(title);
        System.out.println();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].student + ": " + list[i].averageNote);
        }
        System.out.println();
    }

    private static StudentAverage[] sortByQuickSort(int[] averages) {

        StudentAverage[] list = new StudentAverage[averages.length];

        for (int i = 0; i < list.length; i++) {
            list[i] = new StudentAverage(STUDENTS[i], averages[i]);
        }

        quickSort(list, 0, list.length - 1);

        return list;
    }

    private static void quickSort(StudentAverage[] list, int start, int end) {

        int pivote;

        if (start <= end && start >= 0) {
            pivote = quickSortPartition(list, start, end);
            quickSort(list, start, pivote - 1);
            quickSort(list, pivote + 1, end);
        }
    }

    private static int quickSortPartition(StudentAverage[] list, int start, int end) {

        StudentAverage pivote, aux;
        int i;

        pivote = list[end];

        i = start - 1;

        for (int j = start; j < end; j++) {
            if (list[j].averageNote > pivote.averageNote) {
                i++;

                aux = list[i];
                list[i] = list[j];
                list[j] = aux;
            }
        }
        i++;
        aux = list[i];
        list[i] = list[end];
        list[end] = aux;

        return i;
    }

}