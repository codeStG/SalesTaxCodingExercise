package products.impl;

import products.IProduct;

import static checkout.Register.calculateProductFees;

public abstract class Item implements IProduct {
    private final String name;
    private final double price;
    private final boolean isImported;

    //TODO: Possibly change isTaxable to category and base taxability on it
    public Item(String name, double price, boolean isImported) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceWithFees() {
        return Math.round(price + calculateProductFees(this)) * 100.0 / 100.0;
    }

    public boolean isImported() {
        return isImported;
    }

    public abstract boolean isTaxable();
}
