package Utilities;

import products.IProduct;

public interface ICalculator {
    double SALES_TAX = 0.1;
    double IMPORT_DUTY = .05;

    double calculate(IProduct product);
}
