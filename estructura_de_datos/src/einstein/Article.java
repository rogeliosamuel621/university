package einstein;

public class Article {
    private String text;
    Article prevArticle;

    public Article(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
