package model.product;

public abstract class Product {
    protected String id;
    protected String name;
    protected ProductCategory category;
    protected double basePrice;
    protected double taxRate;
    protected String supplier;

    public Product(String id, String name, ProductCategory category, double basePrice, double taxRate, String supplier) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
        this.supplier = supplier;
    }

    public Product(){

    }

    public abstract double getTotalPrice();

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
    public ProductCategory getCategory() {
        return category;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    @Override
    public String toString() {
        return String.format("[%s] %s - %s | Base Price: ₹%.2f | Tax Rate: %.2f%% | Supplier: %s",
                id, name, category, basePrice, taxRate, supplier);
    }

}
