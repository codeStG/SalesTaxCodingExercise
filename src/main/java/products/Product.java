package products;

import utilities.ICalculator;
import utilities.impl.TaxesAndDutiesCalculator;

public class Product {
    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isTaxable;

    //TODO: Possibly change isTaxable to category and base taxability on it
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

    public double getPriceWithFees() {
        ICalculator taxesAndDutiesCalculator = new TaxesAndDutiesCalculator();

        return Math.round(price + taxesAndDutiesCalculator.calculate(this)) * 100.0 / 100.0;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxable() { return isTaxable; };
}
