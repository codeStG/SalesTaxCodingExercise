package products.impl;

import checkout.Register;

public class NonTaxableItem extends Item {

    //Items exempt from taxes include books, food, and medical supplies.
    public NonTaxableItem(String name, double price, boolean isImported, Register register) {
        super(name, price, isImported, register);
    }

    @Override
    public boolean isTaxable() {
        return false;
    }

}
