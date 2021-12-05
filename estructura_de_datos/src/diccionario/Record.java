package diccionario;

public class Record {
    Record next;
    private String word;
    private String definition;

    public Record(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }

    public String getWord() {
        return word;
    }
}
