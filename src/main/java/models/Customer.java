package models;

public class Customer extends Entity {

    private String name;
    private double purchaseAmount;

    public Customer() {
    }

    public Customer(String name, double purchaseAmount) {
        this.name = name;
        this.purchaseAmount = purchaseAmount;
    }

    public Customer(int id, String name, double purchaseAmount) {
        setId(id);
        this.name = name;
        this.purchaseAmount = purchaseAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", purchase amount=" + purchaseAmount +
                '}';
    }
}
