package division_resta_sucesiva;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el dividendo");
        int dividendo = sc.nextInt();

        System.out.println("Digiste el divisor");
        int divisor = sc.nextInt();

        System.out.println("Resultado: " + recursiveDivision(dividendo, divisor));
    }
    private static int recursiveDivision(int dividendo, int divisor){
        if(divisor > dividendo) return 0;

        return 1 + recursiveDivision(dividendo - divisor, divisor);
    }
}
