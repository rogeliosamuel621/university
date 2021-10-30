package mcd;

public class MCD {
    public int getMcd(int num1, int num2) {

        return this.recursiveMcd(num1, num2);
        //return this.mcd(num1, num2);
    }

    public int recursiveMcd(int num1, int num2) {
        if (num2 == 0) return num1;

        return recursiveMcd(num2, num1 % num2);
    }

    public int mcd(int num1, int num2) {
        int aux;
        while (num2 != 0) {
            aux = num2;
            num2 = num1 % num2;
            num1 = aux;
        }
        return num1;
    }
}
