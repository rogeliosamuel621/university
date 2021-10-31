package mcd;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el numero 1: ");
        int num1 = sc.nextInt();

        System.out.println("Digiste el numero 2: ");
        int num2 = sc.nextInt();

        System.out.println("Resultado: " + getMcdRecursively(num1, num2));
    }

    public static int getMcdRecursively(int num1, int num2) {
        if (num2 == 0) return num1;

        return getMcdRecursively(num2, num1 % num2);
    }
}
