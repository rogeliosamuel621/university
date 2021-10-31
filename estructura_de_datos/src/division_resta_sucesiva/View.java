package division_resta_sucesiva;

public class View {
    public static void main(String[] args) {
        System.out.println(recursiveDivision(84232, 4));
    }
    private static int recursiveDivision(int dividendo, int divisor){
        if(divisor > dividendo) return 0;

        return 1 + recursiveDivision(dividendo - divisor, divisor);
    }
}
