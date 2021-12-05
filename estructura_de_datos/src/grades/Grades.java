package grades;

public class Grades {
    int[] grades = new int[11];

    public Grades() {
        this.fillGrades();
    }

    public void sortByMergeSort(int arr[], int left, int right){
        if(left < right){
            int middle = (left + right) / 2;

            sortByMergeSort(arr, left, middle);
            sortByMergeSort(arr, middle+1, right);

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

    public void sortByQuickSort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            sortByQuickSort(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            sortByQuickSort(A,j+1,der);          // ordenamos subarray derecho

    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    private void fillGrades() {
        for(int i=0; i<=10; i++) {
            this.grades[i] = this.getRandomNumber();
        }
    }

    private int getRandomNumber() {
        return (int)((Math.random() * 10));
    }
}
