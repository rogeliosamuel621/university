package evidencia_3;

import java.util.Arrays;

public class App {
    static DataLayer dataLayer;
    static Sort sort;

    public static void main(String[] args) {
        dataLayer = new DataLayer();
        sort = new Sort();

        getTiming(dataLayer.elementsBetween1And5_100000);

    }

    private static void getTiming(int[] array) {
        int[] array1 = Arrays.copyOf(array, array.length);
        int[] array2 = Arrays.copyOf(array, array.length);;
        int[] array3 = Arrays.copyOf(array, array.length);;
        int[] array4 = Arrays.copyOf(array, array.length);;
        int[] array5 = Arrays.copyOf(array, array.length);;
        int[] array6 = Arrays.copyOf(array, array.length);;

        System.out.println();
        System.out.println();
        System.out.println("Obteniendo timing...");
        System.out.println();

        long bubbleSortStart = System.currentTimeMillis();
        sort.bubbleSort(array1);
        long bubbleSortEnd = System.currentTimeMillis();
        long bubbleSortTotalTime =  bubbleSortEnd - bubbleSortStart;
        System.out.println("Bubble sort duró: " + bubbleSortTotalTime + " milisegundos");

        long selectionSortStart = System.currentTimeMillis();
        sort.selectionSort(array2);
        long selectionSortEnd = System.currentTimeMillis();
        long selectionSortTotalTime =  selectionSortEnd - selectionSortStart;
        System.out.println("Selection sort duró: " + selectionSortTotalTime + " milisegundos");

        long insertionSortStart = System.currentTimeMillis();
        sort.insertionSort(array3);
        long insertionSortEnd = System.currentTimeMillis();
        long insertionSortTotalTime =  insertionSortEnd - insertionSortStart;
        System.out.println("Insertion sort duró: " + insertionSortTotalTime + " milisegundos");

        long shellSortStart = System.currentTimeMillis();
        sort.shellSort(array4);
        long shellSortEnd = System.currentTimeMillis();
        long shellSortTotalTime =  shellSortEnd - shellSortStart;
        System.out.println("Shell sort duró: " + shellSortTotalTime + " milisegundos");

        long mergeSortStart = System.currentTimeMillis();
        sort.mergeSort(array5, 0, array5.length - 1);
        long mergeSortEnd = System.currentTimeMillis();
        long mergeSortTotalTime =  mergeSortEnd - mergeSortStart;
        System.out.println("Merge sort duró: " + mergeSortTotalTime + " milisegundos");

        long quickSortStart = System.currentTimeMillis();
        sort.quickSort(array6, 0, array6.length - 1);
        long quickSortEnd = System.currentTimeMillis();
        long quickSortTotalTime =  quickSortEnd - quickSortStart;
        System.out.println("Quick sort duró: " + quickSortTotalTime + " milisegundos");

    }
}
