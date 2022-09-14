package project_1;

public class Client {
    private String name;
    private int[] cars;
    private int amountToPay;

    public Client (String name, int[] cars) {
        this.name=name;
        this.cars=cars;
    }

    public String getName() {
        return name;
    }

    public int[] getCars() {
        return cars;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void upgradeAmountToPay(int price) {
        this.amountToPay = this.amountToPay + price;
    }

}
