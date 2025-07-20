package model.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import model.customer.Customer;
import model.invoice.Invoice;
import model.product.Product;

@SuppressWarnings("unchecked")
public class FileService {
    private static final String CUSTOMER_FILE = "./data/customers.dat";
    private static final String PRODUCT_FILE = "./data/products.dat";
    private static final String INVOICE_FILE = "./data/invoices.dat";
    private static final String BACKUP_FOLDER = "./backup/";

    public void saveCustomers(Map<String, Customer> customers) {
        saveToFile(customers, CUSTOMER_FILE);
    }

    public void saveProducts(Map<String, Product> products) {
        saveToFile(products, PRODUCT_FILE);
    }

    public void saveInvoices(List<Invoice> invoices) {
        saveToFile(invoices, INVOICE_FILE);
    }

    public Map<String, Customer> loadCustomers() {
        return (Map<String, Customer>) loadFromFile(CUSTOMER_FILE);
    }

    public Map<String, Product> loadProducts() {
        return (Map<String, Product>) loadFromFile(PRODUCT_FILE);
    }

    public List<Invoice> loadInvoices() {
        return (List<Invoice>) loadFromFile(INVOICE_FILE);
    }

    public void createBackup() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        new File(BACKUP_FOLDER).mkdirs();
        try {
            Files.copy(Paths.get(CUSTOMER_FILE), Paths.get(BACKUP_FOLDER + "customers_" + timestamp + ".dat"));
            Files.copy(Paths.get(PRODUCT_FILE), Paths.get(BACKUP_FOLDER + "products_" + timestamp + ".dat"));
            Files.copy(Paths.get(INVOICE_FILE), Paths.get(BACKUP_FOLDER + "invoices_" + timestamp + ".dat"));
            System.out.println(" Backup created at " + timestamp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile(Object object, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (Exception e) {
            System.out.println("First-time run or file missing: " + filename);
            return null;
        }
    }
}
