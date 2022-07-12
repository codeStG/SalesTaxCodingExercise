package utilities.impl;

import utilities.ICalculator;
import products.IProduct;

public class TaxCalculator implements ICalculator {

    @Override
    public double calculate(double productPrice) {
        return Math.ceil((productPrice * SALES_TAX) * 20.0) / 20.0;
    }
}
