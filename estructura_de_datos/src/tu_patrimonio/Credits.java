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

    public int[] sortCreditsByInsertionSort(int[] credits) {
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

    public void showCredits(int[] credits) {
        for(int i=0; i<credits.length; i++) {
            System.out.print(credits[i] + ", ");
        }
    }
}
