package Cartas;

public enum Color {
    COIN(1), CUP(2),
    SWORD(3), WAND(4);

    private final int color;

    Color(int color){
        this.color = color;
    }

    public int color(){
        return color;
    }
}
