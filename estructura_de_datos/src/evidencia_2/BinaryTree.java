package evidencia_2;

public class BinaryTree {
    Question root;

    Question fillBinaryTree(Question[] questionsToInsert) {
        for(int i=0; i<questionsToInsert.length; i++) {
            this.insert(questionsToInsert[i]);
        }

        return this.root;
    }

    void insert(Question questionToInsert) {
        if (this.root == null) {
            this.root = questionToInsert;
            return;
        }

        Question currentQuestion = this.root;

        while (true) {
            boolean isEven = currentQuestion.getId() % 2 == 0;

            if (isEven) {
                if (currentQuestion.left == null) {
                    currentQuestion.left = questionToInsert;
                    break;
                }
                currentQuestion = currentQuestion.left;
                break;
            }

            if (currentQuestion.right == null) {
                currentQuestion.right = questionToInsert;
                break;
            }
            currentQuestion = currentQuestion.right;
            break;
        }
    }
}
