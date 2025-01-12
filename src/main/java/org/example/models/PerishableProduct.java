package org.example.models;

import java.time.temporal.ChronoUnit;

public class PerishableProduct extends Product {
    private final Date expiryDate;

    public PerishableProduct(String name, double price,int quantity, Date expiryDate, int vat) {
        super(name, price, quantity, vat);
        this.expiryDate = expiryDate;
    }


    public Date getExpiryDate() {
        return expiryDate;
    }

    public void applyDiscount(double discountPercentage) {
        this.price -= this.price * (discountPercentage / 100);
    }

    public boolean checkExpiry(Date currentDate){
        return currentDate.after(expiryDate);
    }

    public long daysUntilExpiry(Date currentDate) {
        return ChronoUnit.DAYS.between(currentDate.toInstant(), expiryDate.toInstant());
    }

    @Override
    public String toString() {
        return "PerishableProduct{" +
                "expiryDate=" + expiryDate +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
