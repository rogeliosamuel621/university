package evidencia_2;

public class BinaryTree {
    Question root;

    public BinaryTree(Question question) {
        this.root = question;
    }

    Question fillBinaryTree(Question[] questionsToInsert) {
        for(int i=0; i<questionsToInsert.length; i++) {
            this.insert(questionsToInsert[i], this.root);
        }

        return this.root;
    }

    void insert(Question questionToInsert, Question currentQuestion) {

        int questionId = questionToInsert.getId();

        if (questionId < currentQuestion.getId()) {
            if (currentQuestion.left == null) {
                currentQuestion.left = questionToInsert;
                return;
            }

            insert(questionToInsert, currentQuestion.left);
        } else {
            if (questionId > currentQuestion.getId()) {
                if (currentQuestion.right == null) {
                    currentQuestion.right = questionToInsert;
                    return;
                }

                insert(questionToInsert, currentQuestion.right);
            }
        }


    }
}
