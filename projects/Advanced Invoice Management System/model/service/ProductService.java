package model.service;

import java.util.HashMap;
import java.util.Map;

import model.product.Product;

public class ProductService {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        System.out.println("Attempting to add product: " + (product != null ? product.getId() : "null"));
        if (product != null && product.getId() != null) {
            products.put(product.getId(), product);
            System.out.println("Product added successfully: " + product.getId());
        } else {
            System.out.println("Failed to add product: Product or Product ID cannot be null");
            throw new IllegalArgumentException("Product or Product ID cannot be null");
        }
    }
    public Product getProductById(String id) {
        System.out.println("Fetching product by ID: " + id);
        return products.get(id);
    }
    public void updateProduct(Product product) {
        System.out.println("Attempting to update product: " + (product != null ? product.getId() : "null"));
        if (product != null && product.getId() != null && products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            System.out.println("Product updated successfully: " + product.getId());
        } else {
            System.out.println("Failed to update product: Product not found or invalid data");
            throw new IllegalArgumentException("Product not found or invalid data");
        }
    }
    public void deleteProduct(String id) {
        System.out.println("Attempting to delete product with ID: " + id);
        if (id != null && products.containsKey(id)) {
            products.remove(id);
            System.out.println("Product deleted successfully: " + id);
        } else {
            System.out.println("Failed to delete product: Product not found");
            throw new IllegalArgumentException("Product not found");
        }
    }
    public Map<String, Product> getAllProducts() {
        System.out.println("Retrieving all products");
        return new HashMap<>(products);
    }
    public boolean productExists(String id) {
        System.out.println("Checking if product exists with ID: " + id);
        return products.containsKey(id);
    }
    public void clearAllProducts() {
        System.out.println("Clearing all products from the system");
        products.clear();
    }
    public int getProductCount() {
        System.out.println("Getting total product count");
        return products.size();
    }
    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Available Products:");
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
    public Product getProductByName(String name) {
        System.out.println("Searching for product by name: " + name);
        for (Product product : products.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Product found: " + product.getId());
                return product;
            }
        }
        System.out.println("No product found with the given name: " + name);
        return null; // No product found with the given name
    }

}
