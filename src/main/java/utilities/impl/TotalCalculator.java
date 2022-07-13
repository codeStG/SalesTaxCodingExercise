package utilities.impl;

import products.Product;
import utilities.ICalculator;

public class TotalCalculator implements ICalculator {
    @Override
    public double calculate(Product product) {
        TaxesAndDutiesCalculator taxesAndDutiesCalculator = new TaxesAndDutiesCalculator();

        return Math.round((product.getPrice() + taxesAndDutiesCalculator.calculate(product)) * 100.0) / 100.0;
    }
}
