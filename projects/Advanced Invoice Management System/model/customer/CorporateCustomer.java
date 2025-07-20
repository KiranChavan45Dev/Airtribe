package model.customer;

import java.time.LocalDate;

public class CorporateCustomer extends Customer{
    
    private double creditLimit;
    private String paymentTerms;
    private boolean taxExempt;

    public CorporateCustomer() {
        super();
    }

    public CorporateCustomer(String id, String name, String email, String phone, LocalDate registrationDate,
                             double creditLimit, String paymentTerms, boolean taxExempt) {
        super(id, name, email, phone, registrationDate);
        this.creditLimit = creditLimit;
        this.paymentTerms = paymentTerms;
        this.taxExempt = taxExempt;
    }

    @Override
    public double getDiscountRate() {
        return taxExempt ? 0.0d : 5.0d;  // Optional: Apply small discount if not tax exempt
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }
    public boolean isTaxExempt() {
        return taxExempt;
    }
    public void setTaxExempt(boolean taxExempt) {
        this.taxExempt = taxExempt;
    }
    @Override
    public String toString() {
        return "Corporate Customer:\n" + super.toString() +
                String.format("\nCredit Limit: %.2f | Payment Terms: %s | Tax Exempt: %b",
                        creditLimit, paymentTerms, taxExempt);
    }
}
