package utilities.impl;

import utilities.ICalculator;
import products.IProduct;

public class ImportDutyCalculator implements ICalculator {

    @Override
    public double calculate(double productPrice) {
        return Math.ceil((productPrice * IMPORT_DUTY) * 20.0) / 20.0;
    }
}
