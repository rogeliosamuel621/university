package e_5;

public class Cliente {
    private String nombre;
    private int[] carroCompra;
    public int totalPrice;
    // Constructor, getter y setter
    public Cliente (String nom, int[] carro) {
        nombre=nom;
        carroCompra=carro;
    }
    public String getNombre() {
        return nombre;
    }
    public int[] getCarroCompra() {
        return carroCompra;
    }

    public void UpgradeTotalPrice(int price) {
        this.totalPrice = this.totalPrice + price;
    }

}
