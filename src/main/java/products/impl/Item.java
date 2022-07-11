package products.impl;

import products.IProduct;

public abstract class Item implements IProduct {
    private String name;
    private double price;
    private boolean isImported;

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

    public boolean isImported() {
        return isImported;
    }

    public abstract boolean isTaxable();
}
