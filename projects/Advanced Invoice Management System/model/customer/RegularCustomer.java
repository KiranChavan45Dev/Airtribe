package model.customer;

import java.time.LocalDate;

public class RegularCustomer extends Customer {

    public RegularCustomer() {
        // Default constructor
        super();
    }

    public RegularCustomer(String id, String name, String email, String phone, LocalDate registrationDate) {
        super(id, name, email, phone, registrationDate);
    }

    @Override
    public double getDiscountRate() {
        return 0.0d; // Regular customers do not have a discount rate
    }

}