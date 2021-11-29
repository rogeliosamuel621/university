package bubble_sort;

public class View {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        int[] array1 = bubbleSort.generateArray();
        int[] array2 = bubbleSort.generateArray();

        for(int i=0; i<array1.length; i++) {
            System.out.print(array1[i] + ", ");
        }

        System.out.println();
        System.out.println();
        bubbleSort.bubbleSort(array1);
        for(int i=0; i<array1.length; i++) {
            System.out.print(array1[i] + ", ");
        }

        System.out.println("selection");
        bubbleSort.selectionSort(array2);
        for(int i=0; i<array1.length; i++) {
            System.out.print(array1[i] + ", ");
        }

    }
}
