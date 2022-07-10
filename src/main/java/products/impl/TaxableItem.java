package products.impl;

import checkout.Register;

public class TaxableItem extends Item {

    public TaxableItem(String name, double price, boolean isImported, Register register) {
        super(name, price, isImported, register);
    }

    @Override
    public boolean isTaxable() {
        return true;
    }
}
