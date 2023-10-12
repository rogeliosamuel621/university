package simu;

public class Card {

    private final int numero;
    private final char tipoCarta;
    private int nivel;


    public Card(int numero, char tipoCarta) {
        this.numero = numero;
        this.tipoCarta = tipoCarta;
        colocarNivelCarta();
    }

    private void colocarNivelCarta() {

        this.nivel = switch ( tipoCarta ) {
            case 'O' -> 4;
            case 'C' -> 3;
            case 'E' -> 2;
            case 'P' -> 1;
            default -> throw new IllegalArgumentException("ARGUMENTO INVALIDO");
        };

    }

    public int getNumero() {
        return numero;
    }

    public int getNivel() {
        return nivel;
    }

    public String getCarta() {
        return numero + "" + tipoCarta;
    }
}