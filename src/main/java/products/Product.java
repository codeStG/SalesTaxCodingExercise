package products;

public class Product {
    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isTaxable;

    public Product(String name, double price, boolean isImported, boolean isTaxable) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isTaxable = isTaxable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxable() { return isTaxable; };
}
