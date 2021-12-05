package grades;

public class App {
    public static void main(String[] args) {
        Grades grades = new Grades();

        // grades.sortByMergeSort(grades.grades, 0, grades.grades.length - 1);
        grades.sortByQuickSort(grades.grades, 0, grades.grades.length - 1);
        grades.printArray(grades.grades);
    }
}
