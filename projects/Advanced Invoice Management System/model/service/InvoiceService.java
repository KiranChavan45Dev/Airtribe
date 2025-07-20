package model.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.common.DiscountType;
import model.common.PaymentMethod;
import model.common.TaxType;
import model.customer.Customer;
import model.invoice.Invoice;
import model.invoice.InvoiceItem;

public class InvoiceService {
    private List<Invoice> invoices = new ArrayList<>();

    public Invoice createInvoice(Customer customer, List<InvoiceItem> items,
                                  DiscountType discountType, double discountValue,
                                  TaxType taxType, PaymentMethod paymentMethod,
                                  double amountPaid) {

        Invoice invoice = new Invoice(customer, taxType, discountType, discountValue, paymentMethod);
        for (InvoiceItem item : items) {
            invoice.addLineItem(item);
        }

        invoice.setAmountPaid(amountPaid);
        invoices.add(invoice);
        System.out.println("Invoice created: " + invoice.getInvoiceNumber());
        return invoice;
    }

    public List<Invoice> searchByCustomerId(String customerId) {
        return invoices.stream()
                .filter(inv -> inv.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }

    public List<Invoice> searchByDate(LocalDate date) {
        return invoices.stream()
                .filter(inv -> inv.getInvoiceDate().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    public Invoice getInvoiceByNumber(String invoiceNumber) {
        return invoices.stream()
                .filter(inv -> inv.getInvoiceNumber().equalsIgnoreCase(invoiceNumber))
                .findFirst()
                .orElse(null);
    }

    public void processPayment(String invoiceNumber, double amount) {
        Invoice invoice = getInvoiceByNumber(invoiceNumber);
        if (invoice != null) {
            invoice.setAmountPaid(invoice.getAmountPaid() + amount);
            System.out.printf(" Payment of %.2f /- recorded for invoice %s\n", amount, invoiceNumber);
        } else {
            System.out.println("Invoice not found.");
        }
    }

    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    public void loadInvoices(List<Invoice> loadedData) {
        this.invoices = loadedData;
    }

    public List<Invoice> exportInvoices() {
        return invoices;
    }
}
