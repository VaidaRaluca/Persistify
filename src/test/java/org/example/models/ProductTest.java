package org.example.models;


import org.junit.Test;
public class ProductTest {

    @Test
    public void testIsAvailable() {
        Product product = new Product("Test Product", 10.0, 5, 5);

        System.out.println("Testing isAvailable...");
        System.out.println("Initial availability: " + product.isAvailable());

        product.setQuantity(0);
        System.out.println("Availability after setting quantity to 0: " + product.isAvailable());
    }

    @Test
    public void testRestock() {
        Product product = new Product("Test Product", 10.0, 5, 5);

        System.out.println("\nTesting restock...");
        System.out.println("Initial quantity: " + product.getQuantity());

        product.restock(10);
        System.out.println("Quantity after restocking 10: " + product.getQuantity());
    }

    @Test
    public void testCompareTo() {
        Product product1 = new Product("Product 1", 10.0, 5, 5);
        Product product2 = new Product("Product 2", 15.0, 3, 5);
        Product product3 = new Product("Product 3", 10.0, 2, 5);

        System.out.println("\nTesting compareTo...");
        System.out.println("Comparing product1 to product2: " + product1.compareTo(product2));
        System.out.println("Comparing product2 to product1: " + product2.compareTo(product1));
        System.out.println("Comparing product1 to product3: " + product1.compareTo(product3));
    }
}