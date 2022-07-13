package utilities;

import products.Product;

public interface TaxCalculator {
    double SALES_TAX = 0.1;

    double calculateTaxes(double price);
}
