package evidencia_2;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Question[] gameQuestions = {
            new Question("¿es Terrestre?", 5),
            new Question("¿es Terrestre?", 15),
            new Question("¿Tiene 4 patas?", 3),
            new Question("¿Suele encontrarse en medios urbanos?", 7),
            new Question("¿Habita en el mar?", 13),
            new Question("¿Habita en el continente africano?", 17),
            new Question("Pez", 2),
            new Question("Nutria", 4),
            new Question("Ratón", 6),
            new Question("Ardilla", 8),
            new Question("Cocodrilo", 12),
            new Question("Tiburon", 14),
            new Question("Oso", 16),
            new Question("Elefante", 18),
    };

    void start() {
        System.out.println("bienvenido al juego, escoge un animal entre");
        for(int i=7; i<gameQuestions.length; i++) {
            System.out.print(gameQuestions[i].getQuestion() + ", ");
        }
        System.out.println();
        System.out.println();
        Question board = this.createBoard();
        String option = "";
        do {
            this.ask(board);
            System.out.println();
            System.out.println("¿Desea volver a jugar?");
            option = this.sc.next();
        } while (option.equals("si"));

        System.out.println();
        System.out.println();
        System.out.println("El juego ha terminado");

    }

    Question createBoard() {
        BinaryTree binaryTree = new BinaryTree(new Question("¿Es grande?", 10));
        return binaryTree.fillBinaryTree(this.gameQuestions);
    }

    void ask(Question board) {
        final int attempts = 4;
        Question currentQuestion = board;

        for (int i=1; i<=attempts; i++) {
            if (i == attempts) {
                this.endOfTheGame(currentQuestion.getQuestion());
                return;
            }

            String res = "";

            do {
                System.out.println(currentQuestion.getQuestion() + " (Si/No)");
                res = this.sc.next().toLowerCase();

                if (!res.equals("si") && !res.equals("no")) System.out.println("Escoga entre Si/No");
            } while (!res.equals("si") && !res.equals("no"));

            boolean isPositive = res.equals("si");
            currentQuestion = isPositive ? currentQuestion.right : currentQuestion.left;
        }
    }

    void endOfTheGame(String animal) {
        System.out.println("Es la respuesta: " + animal);
        System.out.println("La ronda ha terminado");
    }
}
