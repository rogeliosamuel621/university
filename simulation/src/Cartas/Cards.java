package Cartas;

public class Cards
{
    public int number;
    public Color type;

    public Cards(int number, Color type)
    {
        this.number = number;
        this.type = type;
    }

    public int major(){
        return switch (number){
            case 1 -> 1;
            case 2 -> 10;
            case 3 -> 9;
            case 4 -> 8;
            case 5 -> 7;
            case 6 -> 6;
            case 7 -> 5;
            case 8 -> 4;
            case 9 -> 3;
            case 10 -> 2;
            default -> -1;
        };
    }

    @Override
    public String toString() {
        return "Cards{" +
                "number=" + number +
                ", type=" + type +
                '}';
    }
}
