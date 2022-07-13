package utilities;

import products.Product;

public interface ICalculator {
    double SALES_TAX = 0.1;
    double IMPORT_DUTY = .05;

    double calculate(Product product);
}
