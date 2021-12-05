package grades;

public class App {
    public static void main(String[] args) {
        Grades grades = new Grades();
        int[] grades1 = grades.grades;
        int[] grades2 = grades.grades;

        grades.sortByMergeSort(grades1, 0, grades.grades.length - 1);
        grades.sortByQuickSort(grades2, 0, grades.grades.length - 1);
        grades.printArray(grades1);
        System.out.println("TIMES: " + grades.mergeCount);
        grades.printArray(grades2);
        System.out.println("TIMES: " + grades.quickCount);
    }
}
