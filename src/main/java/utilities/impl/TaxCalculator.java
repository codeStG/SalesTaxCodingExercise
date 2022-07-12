package utilities.impl;

import utilities.ICalculator;

public class TaxCalculator implements ICalculator {

    @Override
    public double calculate(double price) {
        return Math.ceil(price * SALES_TAX * 20.0) / 20.0;
    }
}
