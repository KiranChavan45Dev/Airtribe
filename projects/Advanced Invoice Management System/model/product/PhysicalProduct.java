package model.product;

public class PhysicalProduct extends Product{
    private int stockQuantity;
    private int reorderLevel;

    public PhysicalProduct(String id, String name, ProductCategory category, double basePrice, double taxRate, String supplier, int stockQuantity, int reorderLevel) {
        super(id, name, category, basePrice, taxRate, supplier);
        this.stockQuantity = stockQuantity;
        this.reorderLevel = reorderLevel;
    }
    public PhysicalProduct() {
        super();
    }

    @Override
    public double getTotalPrice() {
        double taxAmount = (basePrice * taxRate) / 100;
        return basePrice + taxAmount;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public int getReorderLevel() {
        return reorderLevel;
    }
    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
    @Override
    public String toString() {
        return "Physical Product:\n" + super.toString() +
                String.format("\nStock: %d | Reorder Level: %d", stockQuantity, reorderLevel);
    }
    
}