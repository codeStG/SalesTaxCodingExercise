package checkout;

import products.IProduct;
import products.impl.Item;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Register {
    private static final double SALES_TAX = 0.1;
    private static final double IMPORT_DUTY = .05;
    private static double subtotal = 0;
    private static double total = 0;
    private static List<IProduct> products = new ArrayList<>();

    public Register() {
        reset();
    }

    public static void reset() {
        subtotal = 0;
        total = 0;
        products = new ArrayList<>();
    }

    public static Receipt submit() {
        calculateTotals();
        return new Receipt(products, subtotal, total);
    }

    public static void scan(IProduct product) {
        products.add(product);
    }

    private static void calculateTotals() {
        for(IProduct product: products) {
            subtotal += Math.round(product.getPrice() * 100.0) / 100.0;
            total += Math.round((product.getPrice() + calculateItemTax(product)) * 100.0) / 100.0;
        }
    }

    public static double calculateItemTax(IProduct product) {
        if(product.isImported() && product.isTaxable()) {
            return (Math.ceil((product.getPrice() * SALES_TAX) * 20.0) / 20.0) + (Math.ceil((product.getPrice() * IMPORT_DUTY) * 20.0) / 20.0);
        } else if(product.isTaxable()){
            return Math.ceil((product.getPrice() * SALES_TAX) * 20.0) / 20.0;
        } else if(product.isImported()) {
            return Math.ceil((product.getPrice() * IMPORT_DUTY) * 20.0) / 20.0;
        } else {
            return 0.0;
        }
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
}