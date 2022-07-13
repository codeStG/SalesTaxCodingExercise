package utilities.impl;

import products.Product;
import utilities.ICalculator;

public class TaxesAndDutiesCalculator implements ICalculator {

    @Override
    public double calculate(Product product) {
        double price = product.getPrice();

        if (product.isImported() && product.isTaxable()) {
            return calculateTaxes(price) + calculateImportDuties(price);
        } else if (product.isTaxable()) {
            return calculateTaxes(price);
        } else if (product.isImported()) {
            return calculateImportDuties(price);
        } else {
            return 0.0;
        }
    }

    public double calculateImportDuties(double price) {
        return Math.ceil(price * IMPORT_DUTY * 20.0) / 20.0;
    }

    public double calculateTaxes(double price) {
        return Math.ceil(price * SALES_TAX * 20.0) / 20.0;
    }
}