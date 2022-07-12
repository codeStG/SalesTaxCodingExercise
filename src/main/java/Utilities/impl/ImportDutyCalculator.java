package Utilities.impl;

import Utilities.ICalculator;
import products.IProduct;

public class ImportDutyCalculator implements ICalculator {

    @Override
    public double calculate(IProduct product) {
        return (Math.ceil((product.getPrice() * IMPORT_DUTY) * 20.0) / 20.0);
    }
}
