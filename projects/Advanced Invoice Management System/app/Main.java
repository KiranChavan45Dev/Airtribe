package app;

import model.common.Address;
import model.common.DiscountType;
import model.common.PaymentMethod;
import model.common.TaxType;
import model.customer.*;
import model.invoice.*;
import model.product.*;
import model.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerService();
    private static final ProductService productService = new ProductService();
    private static final InvoiceService invoiceService = new InvoiceService();
    private static final FileService fileService = new FileService();

    public static void main(String[] args) {
        loadData();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1 : customerManagement();break;
                case 2 : productManagement();break; 
                case 3 : invoiceOperations();break;
                case 4 : System.out.println("📊 Reports coming soon...");break;
                case 5 : fileOperations();break;
                case 0 : {
                    saveData();
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                }
                default : System.out.println("Invalid choice.");
            }
        }
    }

    // Menu methods
    private static void printMainMenu() {
        System.out.println("\n=== INVOICE MANAGEMENT SYSTEM ===");
        System.out.println("1. Customer Management");
        System.out.println("2. Product Management");
        System.out.println("3. Invoice Operations");
        System.out.println("4. Reports & Analytics");
        System.out.println("5. File Operations");
        System.out.println("0. Exit");
    }

    private static void customerManagement() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Customer Management ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. View Customer History");
            System.out.println("0. Back");
            switch (getIntInput("Choose an option: ")) {
                case 1: addCustomer(); break;
                case 2: updateCustomer(); break;
                case 3: {
                    String name = getInput("Enter name to search: ");
                    customerService.searchCustomerByName(name).forEach(System.out::println);
                    break;
                }
                case 4: {
                    String id = getInput("Enter Customer ID: ");
                    customerService.displayCustomerHistory(id);
                    break;
                }
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void productManagement() {
        System.out.println("\n--- Product Management ---");
        System.out.println("1. Add Product");
        System.out.println("2. Search Product");

        switch (getIntInput("Choose an option: ")) {
            case 1 : addProduct(); break;
            case 2 : {
                String name = getInput("Enter name: ");
                Product product = productService.getProductByName(name);
                System.out.println(product != null ? product : "Not found.");
                break;
            }
            default : System.out.println("Invalid choice.");
        }
    }

    private static void invoiceOperations() {
        System.out.println("\n--- Invoice Operations ---");
        System.out.println("1. Create Invoice");
        System.out.println("2. View Invoice");
        System.out.println("3. Search Invoices");
        System.out.println("4. Process Payment");

        switch (getIntInput("Choose an option: ")) {
            case 1 : createInvoice();break;
            case 2 : {
                String inv = getInput("Invoice No: ");
                Invoice invoice = invoiceService.getInvoiceByNumber(inv);
                System.out.println(invoice != null ? invoice : "Not found.");
                break;
            }
            case 3 : {
                String id = getInput("Customer ID: ");
                invoiceService.searchByCustomerId(id)
                        .forEach(System.out::println);

                break;  
            }
            case 4 : {
                String inv = getInput("Invoice No: ");
                double amt = getDoubleInput("Amount: ");
                invoiceService.processPayment(inv, amt);
                break;
            }
            default : System.out.println("Invalid choice.");
        }
    }

    private static void fileOperations() {
        System.out.println("\n--- File Operations ---");
        System.out.println("1. Export Data");
        System.out.println("2. Import Data");
        System.out.println("3. Create Backup");

        switch (getIntInput("Choose an option: ")) {
            case 1 : saveData(); break;
            case 2 : loadData(); break;
            case 3 : fileService.createBackup(); break;
            default : System.out.println("Invalid choice.");
        }
    }

    // === CRUD methods ===

    private static void addCustomer() {
        String id = String.valueOf(1000 + new Random().nextInt(9000));
        String name = getInput("Name: ");
        String email = getInput("Email: ");
        String phone = getInput("Phone: ");
        LocalDate regDate = LocalDate.now();

        System.out.println("Type: 1-Regular, 2-Premium, 3-Corporate");
        int type = getIntInput("Select type: ");

        Customer c = null;
        switch (type) {
            case 1:
                c = new RegularCustomer(id, name, email, phone, regDate);
                break;
            case 2:
                c = new PremiumCustomer(id, name, email, phone, regDate, 10, 100);
                break;
            case 3:
                c = new CorporateCustomer(id, name, email, phone, regDate, 50000, "30 Days", true);
                break;
            default:
                throw new IllegalArgumentException("Invalid type.");
        }

        customerService.addCustomer(c);
    }

    private static void updateCustomer() {
        String id = getInput("Customer ID: ");
        Customer existing = customerService.getCustomerById(id);
        if (existing == null) {
            System.out.println("Customer not found.");
            return;
        }

        String name = getInput("New Name: ");
        String email = getInput("New Email: ");
        String phone = getInput("New Phone: ");

        existing.setName(name);
        existing.setEmail(email);
        existing.setPhone(phone);

        customerService.updateCustomer(existing);
    }

    private static void addProduct() {
        String id = String.valueOf(1000 + new Random().nextInt(9000)); // Changed to 4-digit numeric ID
        String name = getInput("Name: ");
        double price = getDoubleInput("Base Price: ");
        double tax = getDoubleInput("Tax Rate: ");
        ProductCategory category = ProductCategory.valueOf(getInput("Category (ELECTRONICS, CLOTHING, BOOKS, FOOD): ").toUpperCase());

        System.out.println("Type: 1-Physical, 2-Digital");
        int type = getIntInput("Select type: ");

        Product product = null;
        switch (type) {
            case 1:
                product = new PhysicalProduct(id, name, category, price, tax, "Local Supplier", 100, 10);
                break;
            case 2:
                product = new DigitalService(id, name, category, price, tax, "Online Provider");
                break;
            default:
                throw new IllegalArgumentException("Invalid product type.");
        }

        productService.addProduct(product);
    }

    private static void createInvoice() {
        String custId = getInput("Customer ID: ");
        Customer customer = customerService.getCustomerById(custId);
        if (customer == null) {
            System.out.println("Invalid customer.");
            return;
        }

        List<InvoiceItem> items = new ArrayList<>();
        while (true) {
            String prodId = getInput("Product ID (or 'done'): ");
            if (prodId.equalsIgnoreCase("done")) break;

            Product p = productService.getProductById(prodId);
            if (p == null) {
                System.out.println("Product not found.");
                continue;
            }

            int qty = getIntInput("Quantity: ");
            items.add(new InvoiceItem(p, qty));
        }

        DiscountType discountType = DiscountType.PERCENTAGE; // future: ask user
        TaxType taxType = TaxType.GST; // future: choose per product/category
        PaymentMethod paymentMethod = PaymentMethod.CARD;
        double paid = getDoubleInput("Amount Paid: ");

        invoiceService.createInvoice(customer, items, discountType, 10, taxType, paymentMethod, paid);
    }

    // === Utils ===
    private static String getInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int getIntInput(String msg) {
        try {
            return Integer.parseInt(getInput(msg));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static double getDoubleInput(String msg) {
        try {
            return Double.parseDouble(getInput(msg));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void loadData() {
        Map<String, Customer> cust = fileService.loadCustomers();
        Map<String, Product> prod = fileService.loadProducts();
        List<Invoice> invs = fileService.loadInvoices();

        if (cust != null) {
            customerService.clearAllCustomers();
            cust.values().forEach(customerService::addCustomer);
        }
        if (prod != null) {
            productService.clearAllProducts();
            prod.values().forEach(productService::addProduct);
        }
        if (invs != null) invoiceService.loadInvoices(invs);
    }

    private static void saveData() {
        fileService.saveCustomers(customerService.getAllCustomers());
        fileService.saveProducts(productService.getAllProducts());
        fileService.saveInvoices(invoiceService.exportInvoices());
    }
}
