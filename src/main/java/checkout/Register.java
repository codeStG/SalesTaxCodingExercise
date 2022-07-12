package checkout;

import products.IProduct;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static checkout.Receipt.print;

public class Register {
    private static final double SALES_TAX = 0.1;
    private static final double IMPORT_DUTY = .05;
    private static DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private static List<IProduct> products = new ArrayList<>();
    private static double subtotal = 0;
    private static double total = 0;

    public static void scan(IProduct product) {
        products.add(product);
        calculateTotal(product);
    }

    public static void reset() {
        subtotal = 0;
        total = 0;
        products = new ArrayList<>();
    }

    public static void submit() {
        print();
    }

    private static void calculateTotal(IProduct product) {
        subtotal += Math.round(product.getPrice() * 100.0) / 100.0;
        total += Math.round((product.getPrice() + calculateItemTax(product)) * 100.0) / 100.0;
    }

    public static double calculateItemTax(IProduct product) {
        if(product.isImported() && product.isTaxable()) {
            return (Math.ceil((product.getPrice() * SALES_TAX) * 20.0) / 20.0) + ;
        } else if(product.isTaxable()){
            return Math.ceil((product.getPrice() * SALES_TAX) * 20.0) / 20.0;
        } else if(product.isImported()) {
            return Math.ceil((product.getPrice() * IMPORT_DUTY) * 20.0) / 20.0;
        } else {
            return 0.0;
        }
    }

    public static List<IProduct> getProducts() {
        return products;
    }

    public static double getTax() {
        double tax = Math.round((total - subtotal) * 100.0) / 100.0;
        return tax;
    }

    public static String getSubtotal() {
        return decimalFormat.format(subtotal);
    }

    public static String getTotal() {
        return decimalFormat.format(total);
    }
}