package org.example;
import org.example.models.Date;
import org.example.models.NonperishableProduct;
import org.example.models.PerishableProduct;
import org.example.models.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("products.txt");

        if (inputStream == null) {
            System.out.println("File not found!");
            return;
        }
        ArrayList<Product> allProducts = new ArrayList<>();
        ArrayList<PerishableProduct> perishableProducts = new ArrayList<>();
        ArrayList<NonperishableProduct> nonperishableProducts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int quantity = Integer.parseInt(parts[2].trim());
                    Date date = (Date) Date.parse(parts[3].trim());
                    int vat = Integer.parseInt(parts[4].trim());
                    allProducts.add(new Product(name, price, quantity, vat));
                    if (vat == 10)
                        perishableProducts.add(new PerishableProduct(name, price, quantity, date, vat));
                    if (vat == 5)
                        nonperishableProducts.add(new NonperishableProduct(name, price, quantity, date, vat));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        perishableProducts.sort((p1, p2) -> {
            if (p1.getExpiryDate().after(p2.getExpiryDate())) return 1;
            else if (p2.getExpiryDate().after(p1.getExpiryDate())) return -1;
            return 0;
        });


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_perishable_products.txt"))) {
            for (PerishableProduct perishable : perishableProducts) {
                writer.write(perishable.toString());
                writer.newLine();
            }
            System.out.println("Sorted perishable products have been saved to 'sorted_perishable_products.txt'.");
        } catch (Exception e) {
            System.out.println("Error while saving sorted perishable products: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nonperishable_products_less_than_100.txt"))) {
            nonperishableProducts.stream()
                    .filter(product -> product.getPrice() < 100.0)
                    .forEach(product -> {
                        try {
                            writer.write(product.toString());
                            writer.newLine();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println("Filtered nonperishable products have been saved to 'nonperishable_products_less_than_100.txt'.");
        } catch (Exception e) {
            System.out.println("Error while saving nonperishable products: " + e.getMessage());
        }
    }
}
