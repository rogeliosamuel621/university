package einstein;

public class Stack {
    Article top;
    int size;
    int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void insert(String value) throws Exception {
        if (this.size == 0) {
            this.insertAtFirstPosition(value);
            return;
        }

        if (this.isFull()) throw new Exception("La pila esta llena");

        Article articleToInsert = new Article(value);
        articleToInsert.prevArticle = this.top;
        this.top = articleToInsert;
        this.upgradeSize();
    }

    public String remove() throws Exception {
        if (this.isEmpty()) throw new Exception("La pila esta vacia");

        if (this.size == 1) {
            Article articleToRemove = this.top;
            this.top = null;
            this.downgradeSize();
            return articleToRemove.getText();
        }

        Article articleToRemove = this.top;
        Article prevArticle = this.top.prevArticle;
        this.top = articleToRemove;
        this.downgradeSize();
        return prevArticle.getText();
    }


    private void insertAtFirstPosition(String value) {
        Article article = new Article(value);
        this.top = article;
        this.upgradeSize();
    }

    private void upgradeSize() {
        this.size++;
    }

    private void downgradeSize() {
        this.size--;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

}
