package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PerishableProductTest {

    @Test
    public void testApplyDiscount() {
        PerishableProduct product = new PerishableProduct("Milk", 100.0, 10, new Date(2023, 9, 15), 10);
        product.applyDiscount(20.0);
        assertEquals(80.0, product.getPrice(), 0.001, "Price after 20% discount should be 80.0");
        product.applyDiscount(50.0);
        assertEquals(40.0, product.getPrice(), 0.001, "Price after additional 50% discount should be 40.0");
    }

    @Test
    public void testCheckExpiry() {
        Date expiryDate = new Date(2023, 9, 15);
        Date currentDate = new Date(2023, 9, 16);
        PerishableProduct product = new PerishableProduct("Milk", 10.0, 5, expiryDate, 10);
        assertTrue(product.checkExpiry(currentDate), "Product should be expired on 2023-09-16 if expiry is 2023-09-15");
        currentDate = new Date(2023, 9, 14);
        assertFalse(product.checkExpiry(currentDate), "Product should not be expired on 2023-09-14 if expiry is 2023-09-15");
    }



    @Test
    public void testDaysUntilExpiry() {
        Date expiryDate = new Date(2023, 9, 20);
        Date currentDate = new Date(2023, 9, 15);
        PerishableProduct product = new PerishableProduct("Yogurt", 5.0, 10, expiryDate, 10);
        assertEquals(5, product.daysUntilExpiry(currentDate), "Days until expiry should be 5 when expiry is 2023-09-20 and current date is 2023-09-15");
        currentDate = new Date(2023, 9, 20);
        assertEquals(0, product.daysUntilExpiry(currentDate), "Days until expiry should be 0 on the expiry date");
    }



}