package evidencia_2;

import java.util.Scanner;

public class Game {
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
        Scanner sc = new Scanner(System.in);
        Question board = this.createBoard();

        final int attempts = 4;
        Question currentQuestion = board;

        for (int i=1; i<=attempts; i++) {
            if (i == attempts) {
                System.out.println(currentQuestion.getQuestion());
                System.out.println("finalizado");
                return;
            }

            System.out.println(currentQuestion.getQuestion());
            int res = sc.nextInt();

            currentQuestion = res == 1 ? currentQuestion.right : currentQuestion.left;
        }
    }

    Question createBoard() {
        BinaryTree binaryTree = new BinaryTree(new Question("¿Es grande?", 10));
        return binaryTree.fillBinaryTree(this.gameQuestions);
    }
}
