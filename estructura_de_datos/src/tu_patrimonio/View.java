package tu_patrimonio;

public class View {
    public static void main(String[] args) {
        Credits credits = new Credits();

        int[] credits1 = credits.generateCredits();
        int[] credits2 = credits.generateCredits();

        long insertionSortStart = System.currentTimeMillis();
        credits.sortCreditsByInsertionSort(credits1);
        long insertionSortEnd = System.currentTimeMillis();
        long totalInsertionSort = insertionSortEnd - insertionSortStart;
        System.out.println("Insertion sort duró: " + totalInsertionSort + " milisegundos");

        long shellSortStart = System.currentTimeMillis();
        credits.sortCreditsByShellSort(credits2);
        long shellSortEnd = System.currentTimeMillis();
        long totalShellSort = shellSortEnd - shellSortStart;
        System.out.println("Shell sort duró: " + totalShellSort + " milisegundos");

    }


}
