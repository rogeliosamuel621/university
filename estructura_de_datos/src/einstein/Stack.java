package einstein;

import java.util.concurrent.TimeUnit;

public class Stack {
    Article top;
    int size;
    int capacity;
    private final int EDITOR_MONTHS = 3;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void start() {
        int counter = 0;
        int timeElapsed = 0;
        while(true) {
            counter++;
            int einsteinMonths = getRandomNumber() - timeElapsed;
            System.out.println("meses para entregar: " + einsteinMonths);
            this.await(einsteinMonths);

            try {
                this.insert("Articulo: " + counter);
                System.out.println("Articulo entregado, numeros de articulos en cola: " + this.size);
                int _editorMonths = this.EDITOR_MONTHS - einsteinMonths;
                System.out.println("Meses para publicar: " + _editorMonths);

                if (_editorMonths < 0) {
                    System.out.println("El editor no encontro ningun articulo ");
                    timeElapsed = _editorMonths;
                    continue;
                }

                this.await(_editorMonths);
                this.remove();

                System.out.println("numero de articulos en cola: " + this.size);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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

    private int getRandomNumber() {
        return (int)((Math.random() * 3) + 1);
    }

    private void await(int number) {
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
