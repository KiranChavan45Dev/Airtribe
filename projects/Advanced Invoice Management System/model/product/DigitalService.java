package model.product;

public class DigitalService extends Product {
    
    public DigitalService() {
        super();
    }

    public DigitalService(String id, String name, ProductCategory category, double basePrice,
                          double taxRate, String supplier) {
        super(id, name, category, basePrice, taxRate, supplier);
    }

    @Override
    public double getTotalPrice() {
        // TODO Auto-generated method stub
        double taxAmount = (basePrice * taxRate) / 100;
        return basePrice + taxAmount;
    }

    @Override
    public String toString() {
        return "Digital Service:\n" + super.toString();
    }
    
}
