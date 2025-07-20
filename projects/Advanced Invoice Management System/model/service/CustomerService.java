package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.customer.Customer;
import model.invoice.Invoice;

public class CustomerService {
    private Map<String, Customer> customerData = new HashMap<>();

    public void addCustomer(Customer customer) {
        System.out.println("Attempting to add customer: " + (customer != null ? customer.getId() : "null"));
        if (customer != null && customer.getId() != null) {
            customerData.put(customer.getId(), customer);
            System.out.println("Customer added successfully: " + customer.getId());
        } else {
            System.out.println("Failed to add customer: Invalid customer data");
            throw new IllegalArgumentException("Invalid customer data");
        }
    }
    public Customer getCustomerById(String id) {
        System.out.println("Fetching customer by ID: " + id);
        return customerData.get(id);
    }
    public void updateCustomer(Customer customer) {
        System.out.println("Attempting to update customer: " + (customer != null ? customer.getId() : "null"));
        if (customer != null && customer.getId() != null && customerData.containsKey(customer.getId())) {
            customerData.put(customer.getId(), customer);
            System.out.println("Customer updated successfully: " + customer.getId());
        } else {
            System.out.println("Failed to update customer: Customer not found or invalid data");
            throw new IllegalArgumentException("Customer not found or invalid data");
        }
    }
    public void deleteCustomer(String id) {
        System.out.println("Attempting to delete customer with ID: " + id);
        if (id != null && customerData.containsKey(id)) {
            customerData.remove(id);
            System.out.println("Customer deleted successfully: " + id);
        } else {
            System.out.println("Failed to delete customer: Customer not found");
            throw new IllegalArgumentException("Customer not found");
        }
    }
    public Map<String, Customer> getAllCustomers() {
        System.out.println("Retrieving all customers");
        return new HashMap<>(customerData);
    }
    public boolean customerExists(String id) {
        System.out.println("Checking if customer exists with ID: " + id);
        return customerData.containsKey(id);
    }
    public void clearAllCustomers() {
        System.out.println("Clearing all customers from the system");
        customerData.clear();
    }
    public int getCustomerCount() {
        System.out.println("Getting total customer count");
        return customerData.size();
    }
    public Customer getCustomerByEmail(String email) {
        System.out.println("Searching for customer by email: " + email);
        return customerData.values().stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
    public Customer getCustomerByPhone(String phone) {
        System.out.println("Searching for customer by phone: " + phone);
        return customerData.values().stream()
                .filter(customer -> customer.getPhone().equals(phone))
                .findFirst()
                .orElse(null);
    }
    public List<Customer> searchCustomerByName(String name) {
        System.out.println("Searching for customers by name: " + name);
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Search name is null or empty.");
            return new ArrayList<>();
        }
        List<Customer> result = customerData.values().stream()
                .filter(customer -> customer.getName() != null && customer.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Found " + result.size() + " customer(s) matching: " + name);
        return result;
    }
    public void displayCustomerHistory(String id) {
        System.out.println("Displaying purchase history for customer ID: " + id);
        Customer customer = customerData.get(id);
        if (customer == null) {
            System.out.println("Customer not found with ID: " + id);
            return;
        }
        // This is a placeholder. In a real system, you would fetch invoices or orders for this customer.
        // For now, just print customer details.
        System.out.println("Customer Details:");
        System.out.println(customer);
        System.out.println("Purchase history feature not implemented yet.");
    }
}
