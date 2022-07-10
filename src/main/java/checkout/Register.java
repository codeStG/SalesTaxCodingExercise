package checkout;

import products.IProduct;
import products.impl.Item;

import java.util.List;

public class Register {
    private final double salesTax;
    private final double importDuty;
    private double subtotal;
    private double total;

    public Register(double salesTax, double importDuty) {
        this.salesTax = salesTax;
        this.importDuty = importDuty;
    }

    public void reset() {
        subtotal = 0;
        total = 0;
    }

    public Receipt submit(List<Item> items) {
        return new Receipt(items, subtotal, total);
    }

    public void scan(IProduct product) {
        this.subtotal += Math.round(product.getPrice() * 100.0) / 100.0;
        this.total += Math.round((product.getPrice() + product.getItemTax()) * 100.0) / 100.0;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    public double getTotal() {
        return this.total;
    }

    public double getSalesTax() {
        return this.salesTax;
    }

    public double getImportDuty() {
        return this.importDuty;
    }
}