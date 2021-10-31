package mcd;

public class View {
    public static void main(String[] args) {
        System.out.println(getMcdRecursively(180, 324));
        System.out.println(getMcdRecursively(10, 15));
    }

    public static int getMcdRecursively(int num1, int num2) {
        if (num2 == 0) return num1;

        return getMcdRecursively(num2, num1 % num2);
    }
}
