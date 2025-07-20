package model.invoice;

import java.io.Serializable;

import model.product.Product;

public class InvoiceItem implements Serializable{
    private Product product;
    private int quantity;

    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public InvoiceItem() {
        
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getTotalPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s\nQty: %d | Subtotal: ₹%.2f",
                product.getName(), quantity, getSubtotal());
    }
}
