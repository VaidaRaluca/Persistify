package org.example.models;

import org.example.interfaces.IProduct;

public class Product implements IProduct {
    protected String name;
    protected double price;
    protected int quantity;
    protected int vat;

    public Product(String name, double price, int quantity, int vat) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.vat = vat;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean isAvailable() {
        return quantity > 0;
    }

    @Override
    public void restock(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return Double.compare(this.price, otherProduct.price);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getVat() {
        return vat;
    }
    @Override
    public void setVat(int vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", vat=" + vat +
                '}';
    }
}
