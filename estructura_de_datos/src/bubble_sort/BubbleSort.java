package bubble_sort;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int length = arr.length;
        int aux = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    aux = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    public int[] selectionSort(int array[]) {
        int menor = 0;
        int pos = 0;
        int aux = 0;
        for (int i = 0; i < array.length - 1; i++) {
            menor = array[i];
            pos = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < menor) {
                    menor = array[j];
                    pos = j;
                }
            }
            if (pos != i){
                aux = array[i];
                array[i] = array[pos];
                array[pos] = aux;
            }
        }

        return array;
    }

    public int[] generateArray() {
        final int LIMIT = 1000;
        int[] array = new int[LIMIT];

        for (int i=0; i<LIMIT; i++) {
            int randomNumber = (int)(Math.random() * 1000);
            array[i] = randomNumber;
        }

        return array;
    }


}
