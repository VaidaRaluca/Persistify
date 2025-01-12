package org.example.models;

public class NonperishableProduct extends Product {
    private final Date fabricationDate;
    public NonperishableProduct(String name, double price, int quantity, Date fabricationDate, int vat) {
        super(name, price, quantity, vat);
        this.fabricationDate = fabricationDate;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    @Override
    public String toString() {
        return "NonperishableProduct{" +
                "fabricationDate=" + fabricationDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
