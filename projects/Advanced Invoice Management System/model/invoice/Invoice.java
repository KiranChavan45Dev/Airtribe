package model.invoice;

import model.customer.Customer;
import model.common.TaxType;
import model.common.DiscountType;
import model.common.PaymentMethod;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Invoice implements Serializable {
    private String invoiceNumber;
    private Customer customer;
    private List<InvoiceItem> lineItems;
    private LocalDateTime invoiceDate;
    private TaxType taxType;
    private DiscountType discountType;
    private double discountValue;
    private double amountPaid;
    private PaymentMethod paymentMethod;

    public Invoice() {
        this.invoiceNumber = generateInvoiceNumber();
        this.lineItems = new ArrayList<>();
        this.invoiceDate = LocalDateTime.now();
    }

    public Invoice(Customer customer, TaxType taxType, DiscountType discountType,
                   double discountValue, PaymentMethod paymentMethod) {
        this();
        this.customer = customer;
        this.taxType = taxType;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.paymentMethod = paymentMethod;
    }

    private String generateInvoiceNumber() {
        return "INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void addLineItem(InvoiceItem item) {
        lineItems.add(item);
    }

    public double getTotalBeforeDiscount() {
        return lineItems.stream().mapToDouble(InvoiceItem::getSubtotal).sum();
    }

    public double getDiscountAmount() {
        double total = getTotalBeforeDiscount();
        if (discountType == DiscountType.PERCENTAGE) {
            return (total * discountValue) / 100;
        } else if (discountType == DiscountType.FIXED_AMOUNT) {
            return discountValue;
        } else if (discountType == DiscountType.BULK_DISCOUNT) {
            // Implement bulk discount logic if needed
            return total > 10000 ? total * 0.1 : 0; // Example: 10% off for totals over ₹10,000
        }
        return 0; // No discount
    }

    public double getFinalTotal() {
        return getTotalBeforeDiscount() - getDiscountAmount();
    }

    public double getBalanceDue() {
        return getFinalTotal() - amountPaid;
    }

    // Getters and Setters
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<InvoiceItem> getLineItems() {
        return lineItems;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Invoice #" + invoiceNumber +
                "\nDate: " + invoiceDate +
                "\nCustomer: " + customer.getName() +
                "\nItems:\n" + lineItems +
                String.format("\nTotal: ₹%.2f | Discount: ₹%.2f | Final: ₹%.2f | Paid: ₹%.2f | Due: ₹%.2f",
                        getTotalBeforeDiscount(), getDiscountAmount(), getFinalTotal(), amountPaid, getBalanceDue());
    }
}
