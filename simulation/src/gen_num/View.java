package gen_num;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner((System.in));
    public static void main(String[] args) {
        generateMenu();
    }

    static private void generateMenu() {
        int option;
        boolean control = true;

        do {
            System.out.print("\tMenu\n"
                    + "\n1.- Digite semilla."
                    + "\n2.- Generar semilla."
                    + "\n3.- Salir."
                    + "\n\nOPCION: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    int seed1 = digitSeed();
                    System.out.println(seed1);
                    process(seed1);
                    break;
                case 2:
                    int seed2 = getSeed();
                    System.out.println(seed2);
                    process(seed2);
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("ERROR, ingrese una de las opciones.");
                    break;
            }

        }while(control);
    }

    static int getSeed() {
        return (int)((Math.random() * (100 - 999) + 999));
    }

    static int digitSeed() {
        int seed;
        boolean control = false;

        do {
            System.out.println("Digite la semilla");
            seed = sc.nextInt();

            if (seed >= 100 && seed <= 999) {
                control = true;
            }
        } while (control == false);

        return seed;
    }

    static void process(int seed) {
        int currentSeed = seed;
        int numInt = 0;
        int cont = 0;
        ArrayList<Integer> results = new ArrayList<>();
        boolean isFinished = false;
        System.out.println("n    semilla    cuadrado     num int     siguiente num");
        do {
            cont++;
            int quadraticSeed = currentSeed * currentSeed;
            String seedInString = Integer.toString(quadraticSeed);

            if (seedInString.length() == 5) {
                seedInString = seedInString.substring(1, seedInString.length() - 1);
                numInt = Integer.parseInt(seedInString);
            }

            if (seedInString.length() == 6) {
                numInt = Integer.parseInt(seedInString.substring(1, 5));
                seedInString = seedInString.substring(1, 4);
            }


            int nextSeed = Integer.parseInt(seedInString);
                System.out.println(cont +  "\t\t" + currentSeed + "\t\t" + quadraticSeed + "\t\t" + numInt + "\t\t\t\t" + nextSeed);
            currentSeed = nextSeed;

            if (currentSeed < 100) {
                isFinished = true;
            }

            for (int i = 0; i < results.size(); i++) {
                if (currentSeed == results.get(i)) {
                    isFinished = true;
                    break;
                }
            }

            results.add(currentSeed);

            System.out.println();

        }while (isFinished == false);

        int media = getMedia(results);
        double standardDeviation = getStandardDeviation(results, media);
        System.out.println("La media es: " + media);
        System.out.println("La desviacióin estandar es: " + standardDeviation);


    }

    static int getMedia(ArrayList<Integer> numbers) {
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            result = result + numbers.get(i);
        }

        return  result / numbers.size();
    }

    static double getStandardDeviation(ArrayList<Integer> entities, int media) {
        double summation = 0;
        for (int i = 0; i < entities.size(); i++) {
            summation = entities.get(i) - media;
        }

        return Math.sqrt((summation * summation) / entities.size());
    }

}
