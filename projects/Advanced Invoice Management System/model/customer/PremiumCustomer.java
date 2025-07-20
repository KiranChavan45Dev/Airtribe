package model.customer;

import java.time.LocalDate;


public class PremiumCustomer extends Customer{
    private double discountPercentage;
    private int loyaltyPoints;

    public PremiumCustomer() {
        super();
    }

    public PremiumCustomer(String id, String name, String email, String phone, LocalDate registrationDate, double discountPercentage, int loyaltyPoints) {
        super(id, name, email, phone, registrationDate);
        this.discountPercentage = discountPercentage;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public double getDiscountRate() {
        return discountPercentage;
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Premium Customer:\n" + super.toString() +
                String.format("\nDiscount: %.2f%% | Loyalty Points: %d",
                        discountPercentage, loyaltyPoints);
    }
}
