package utilities.impl;

import products.Product;
import utilities.ICalculator;

public class SubTotalCalculator implements ICalculator {
    @Override
    public double calculate(Product product) {
        return Math.round(product.getPrice() * 100.0) / 100.0;
    }
}
