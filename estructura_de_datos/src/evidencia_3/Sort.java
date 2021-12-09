package evidencia_3;

public class Sort {
    /**
     * Bubble sort
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int length = arr.length;
        int aux = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    aux = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    /**
     * Selection sort
     * @param array
     * @return
     */
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

    /**
     * Shell sort
     * @param credits
     * @return
     */
    public int[] shellSort(int[] credits) {
        int jump, aux;
        boolean hasBeenChanged;

        for (jump = credits.length / 2; jump != 0; jump /= 2) {
            hasBeenChanged = true;
            while (hasBeenChanged) {
                hasBeenChanged = false;
                for (int i = jump; i < credits.length; i++) {
                    if (credits[i - jump] > credits[i]) {
                        aux = credits[i];
                        credits[i] = credits[i - jump];
                        credits[i - jump] = aux;
                        hasBeenChanged = true;
                    }
                }
            }
        }

        return credits;
    }

    /**
     * Insertion sort
     * @param credits
     * @return
     */
    public int[] insertionSort(int[] credits) {
        int key = 0;
        int j = 0;
        for (int i = 1; i < credits.length; i++) {
            key = credits[i];
            j = i - 1;
            while (j >= 0 && credits[j] > key) {
                credits[j + 1] = credits[j];
                j = j - 1;
            }
            credits[j + 1] = key;
        }

        return credits;
    }

    /**
     * Merge sort
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int arr[], int left, int right){
        if(left < right){
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);

            this.merge(arr, left, middle, right);
        }
    }

    public void merge(int arr[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * Quick sort
     * @param A
     * @param izq
     * @param der
     */
    public void quickSort(int A[], int izq, int der) {
        int pivote=A[izq];
        int i=izq;
        int j=der;
        int aux;

        while(i < j){
            while(A[i] <= pivote && i < j) i++;
            while(A[j] > pivote) j--;
            if (i < j) {
                aux= A[i];
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];
        A[j]=pivote;

        if(izq < j-1)
            quickSort(A,izq,j-1);
        if(j+1 < der)
            quickSort(A,j+1,der);

    }
}
