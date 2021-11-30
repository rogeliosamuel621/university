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

    public int[] sortCreditsByShellSort(int[] credits) {
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

    public int[] sortCreditsByInsertionSort(int[] arr) {
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
