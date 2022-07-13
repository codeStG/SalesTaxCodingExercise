package utilities.impl;

import products.Product;
import utilities.ImportDutiesCalculator;
import utilities.SubTotalCalculator;
import utilities.TaxCalculator;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator implements SubTotalCalculator, TaxCalculator, ImportDutiesCalculator {

    private final List<Product> shoppingCart;

    public PriceCalculator(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public PriceCalculator(Product product) {
        this.shoppingCart = new ArrayList<>();
        this.shoppingCart.add(product);
    }

    public double calculateTotal() {
        return Math.round((calculateSubTotal() + calculateAllFees()) * 100.0) / 100.0;
    }

    @Override
    public double calculateSubTotal() {
        double subTotal = 0;

        for(Product product : shoppingCart) {
            subTotal += Math.round(product.getPrice() * 100.0) / 100.0;
        }

        return subTotal;
    }

    public double calculateAllFees() {
        double fees = 0;

        for(Product product : shoppingCart) {
            if (product.isTaxable()) {
                fees += calculateTaxes(product.getPrice());
            }

            if (product.isImported()) {
                fees += calculateImportDuties(product.getPrice());
            }
        }

        return fees;
    }

    @Override
    public double calculateTaxes(double price) {
        return Math.ceil(price * SALES_TAX * 20.0) / 20.0;
    }

    @Override
    public double calculateImportDuties(double price) {
        return Math.ceil(price * IMPORT_DUTY * 20.0) / 20.0;
    }
}