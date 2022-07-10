package checkout;

import products.IProduct;
import static checkout.Register.calculateItemTax;

import java.util.List;

public class Receipt {
    private final List<IProduct> products;
    private final double subtotal;
    private final double total;

    //TODO: This is way too complex; a receipt prints out information. That is it
    public Receipt(List<IProduct> products, double subtotal, double total) {
        this.products = products;
        this.subtotal = subtotal;
        this.total = total;
    }

    public double getSubtotal() {
        return Math.round(subtotal * 100.0) / 100.0;
    }

    public double getTotal() {
        return Math.round(total * 100.0) / 100.0;
    }

    public double getTax() {
        double tax = Math.round((getTotal() - getSubtotal()) * 100.0) / 100.0;
        return tax;
    }

    public void print() {
        for(IProduct product : products) {
            System.out.println(product.getName());
            System.out.println("\t\t\t\t\t" + Math.round((product.getPrice() + calculateItemTax(product)) * 100.0) / 100.0);
            System.out.println("--------------------------");
        }
        System.out.println("\nSubtotal: \t\t\t" + getSubtotal());
        System.out.println("Tax: \t\t\t\t" + getTax());
        System.out.println("Total: \t\t\t\t" + getTotal());
        System.out.println();
    }
}
