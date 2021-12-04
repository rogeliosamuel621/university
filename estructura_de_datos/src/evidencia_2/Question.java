package evidencia_2;

public class Question {
    private String question;
    private int id;

    Question(String question, int id) {
        this.question = question;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public int getId() {
        return id;
    }
}
