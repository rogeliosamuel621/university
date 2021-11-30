package bubble_sort;

public class View {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] array1 = bubbleSort.generateArray();
        int[] array2 = bubbleSort.generateArray();

        long bubbleSortStart = System.currentTimeMillis();
        bubbleSort.bubbleSort(array1);
        long bubbleSortEnd = System.currentTimeMillis();
        long bubbleSortTotalTime =  bubbleSortEnd - bubbleSortStart;
        System.out.println("Bubble sort duró: " + bubbleSortTotalTime + " milisegundos");

        long selectionSortStart = System.currentTimeMillis();
        bubbleSort.selectionSort(array2);
        long selectionSortEnd = System.currentTimeMillis();
        long selectionSortTotalTime = selectionSortEnd - selectionSortStart;
        System.out.println("Selection sort duró: " + selectionSortTotalTime + " milisegundos");

    }
}