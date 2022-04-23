package baraja;

public class Carta {

    public String tipoCarta;
    public int numeroCarta;

    @Override
    public String toString() {
        return "Carta{" + "tipoCarta=" + tipoCarta + ", numeroCarta=" + numeroCarta + '}';
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public int getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(int numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

}
