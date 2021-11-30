package tu_patrimonio;

public class View {
    public static void main(String[] args) {
        Credits credits = new Credits();

        int[] credits1 = credits.generateCredits();
        int[] credits2 = credits.generateCredits();

        credits.sortCreditsByInsertionSort(credits1);
        credits.sortCreditsByShellSort(credits2);

        credits.showCredits(credits1);
        System.out.println();
        credits.showCredits(credits2);

    }


}
