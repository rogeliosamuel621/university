package evidencia_2;

public class Game {
    Question[] gameQuestions = {
            new Question("¿es Terrestre?", 5),
            new Question("¿es Terrestre?", 15),
            new Question("¿Habita en el mar?", 3),
            new Question("¿Habita en el continente africano?", 7),
            new Question("¿Suele encontrarse en medios urbanos?", 13),
            new Question("¿Tiene 4 patas?", 17),
            new Question("Cocodrilo", 2),
            new Question("Tiburon", 4),
            new Question("Elefante", 6),
            new Question("Oso", 8),
            new Question("Ratón", 12),
            new Question("Ardilla", 14),
            new Question("Pez", 16),
            new Question("Nutria", 18),
    };

    void start() {
        Question board = this.createBoard();
        System.out.println(board.left.getQuestion());
    }

    Question createBoard() {
        BinaryTree binaryTree = new BinaryTree(new Question("¿Es grande?", 10));
        return binaryTree.fillBinaryTree(this.gameQuestions);
    }
}
