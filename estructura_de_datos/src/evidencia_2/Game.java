package evidencia_2;

public class Game {
    Question[] gameQuestions = {
            new Question("¿Es grande?", 1),
            new Question("¿Es grande?", 2),
            new Question("¿Es grande?", 3),
            new Question("¿Es grande?", 4),
            new Question("¿Es grande?", 6),
            new Question("¿Es grande?", 5),
            new Question("¿Es grande?", 7),
            new Question("¿Es grande?", 8),
            new Question("¿Es grande?", 10),
            new Question("¿Es grande?", 12),
            new Question("¿Es grande?", 14),
            new Question("¿Es grande?", 9),
            new Question("¿Es grande?", 11),
            new Question("¿Es grande?", 13),
            new Question("¿Es grande?", 15),
    };

    void start() {
        Question board = this.createBoard();
        System.out.println(board.left.getQuestion());
    }

    Question createBoard() {
        BinaryTree binaryTree = new BinaryTree();
        return binaryTree.fillBinaryTree(this.gameQuestions);
    }
}
