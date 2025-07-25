package model.customer;

import java.time.LocalDate;


public abstract class Customer {
    protected String id;
    protected String name;
    protected String email;
    protected String phone;
    protected LocalDate registrationDate;

    public Customer() {
        // Default constructor
    }

    public Customer(String id, String name, String email, String phone, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
    }

    public abstract double getDiscountRate();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    @Override
    public String toString() {
        return String.format("[%s] %s (%s)\nPhone: %s\nRegistered: %s\n",
                id, name, email, phone, registrationDate);
    }
}
