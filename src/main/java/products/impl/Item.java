package products.impl;

import checkout.Register;
import products.IProduct;

public abstract class Item implements IProduct {
    private final String name;
    private final double price;
    private final boolean isImported;
    private double itemTax;

    public Item(String name, double price, boolean isImported, Register register) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        if(isImported() && isTaxable()) {
            this.itemTax = Math.ceil((this.price * register.getSalesTax()) * 20.0) / 20.0;
            this.itemTax += Math.ceil((this.price * register.getImportDuty()) * 20.0) / 20.0;
        } else if(isTaxable()){
            this.itemTax = Math.ceil((this.price * register.getSalesTax()) * 20.0) / 20.0;
        } else if(isImported()) {
            this.itemTax += Math.ceil((this.price * register.getImportDuty()) * 20.0) / 20.0;
        } else {
            this.itemTax = 0.0;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getItemTax() {
        return itemTax;
    }

    public boolean isImported() {
        return isImported;
    }

    public abstract boolean isTaxable();
}
