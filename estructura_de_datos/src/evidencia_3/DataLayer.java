package evidencia_3;

public class DataLayer {
    int[] randomElements_100 = new int[100];
    int[] randomElements_50000 = new int[50000];
    int[] randomElements_100000 = new int[100000];
    int[] sortedElementsToDown_100000 = new int[100000];
    int[] sortedElements_100000 = new int[100000];
    int[] elementsBetween1And5_100000 = new int[100000];

    public DataLayer() {
        System.out.println("llenando los 100...");
        this.fillRandomElements(this.randomElements_100, false);
        System.out.println("Terminado");

        System.out.println();
        System.out.println("Llenando los 50,000...");
        this.fillRandomElements(this.randomElements_50000, false);
        System.out.println("Terminado");

        System.out.println();
        System.out.println("Llenando los 100,000...");
        this.fillRandomElements(this.randomElements_100000, false);
        System.out.println("Terminado");

        System.out.println();
        System.out.println("Llenando 100,000...");
        this.fillRandomElements(this.sortedElementsToDown_100000, false);
        System.out.println("Ordenando hacia abajo...");
        this.sortArrayToDown(this.sortedElementsToDown_100000);
        System.out.println("Terminado");

        System.out.println();
        System.out.println("Llenando los 100,000...");
        this.fillRandomElements(this.sortedElements_100000, false);
        System.out.println("Ordenando...");
        this.sortArray(this.sortedElements_100000);
        System.out.println("Terminado");

        System.out.println();
        System.out.println("Llenando los 100,000 entre 1 y 5...");
        this.fillRandomElements(elementsBetween1And5_100000, true);
        System.out.println("Terminado");
    }

    private void fillRandomElements(int[] array, boolean isSpecial) {
        for(int i=0; i<array.length; i++) {
            int randomNumber = isSpecial ? this.getRandomNumber(1, 5) : this.getRandomNumber();
            array[i] = randomNumber;
        }
    }

    private void sortArrayToDown(int[] arr) {
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

    private void sortArray(int[] arr) {
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

    private int getRandomNumber(int min, int max) {
        return (int)((Math.random() * max) + min);
    }

    private int getRandomNumber() {
        return (int)((Math.random() * 100000) + 0);
    }
}
