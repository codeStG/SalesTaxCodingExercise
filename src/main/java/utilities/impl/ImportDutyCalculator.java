package utilities.impl;

import utilities.ICalculator;
import products.IProduct;

public class ImportDutyCalculator implements ICalculator {

    @Override
    public double calculate(double price) {
        return Math.ceil(price * IMPORT_DUTY * 20.0) / 20.0;
    }
}
