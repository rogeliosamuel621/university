package tu_patrimonio;

public class Credits {
    public int[] generateCredits() {
        final int LIMIT = 590;
        int[] credits = new int[LIMIT];

        for (int i=0; i<LIMIT; i++) {
            int randomNumber = (int)(Math.random() * 1000);
            credits[i] = randomNumber;
        }

        return credits;
    }

    public int[] sortCreditsByShellSort(int[] A) {
        int salto, aux, i;
        boolean cambios;

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < A.length; i++)   // se da una pasada
                {
                    if (A[i - salto] > A[i]) {       // y si están desordenados
                        aux = A[i];                  // se reordenan
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.
                    }
                }
            }
        }

        return A;
    }

    public int[] sortCreditsByInsertionSort(int[] arr){
        int i, key, j;
        for (i = 1; i < arr.length; i++)
        {
            key = arr[i];
            j = i - 1;

        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    public void showCredits(int[] credits) {
        for(int i=0; i<credits.length; i++) {
            System.out.print(credits[i] + ", ");
        }
    }
}
