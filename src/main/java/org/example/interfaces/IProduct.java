package org.example.interfaces;

import org.example.models.Product;

public interface IProduct {
    double getPrice();
    int getQuantity();
    String getName();
    int getVat();
    void setVat(int vat);
    void setName(String name);
    void setPrice(double price);
    void setQuantity(int quantity);
    boolean isAvailable();
    void restock(int quantity);
    int compareTo(Product otherProduct);
}
