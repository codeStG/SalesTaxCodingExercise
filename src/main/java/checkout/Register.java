package checkout;

import products.IProduct;
import utilities.ICalculator;
import utilities.impl.ImportDutyCalculator;
import utilities.impl.TaxCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static checkout.Receipt.print;

public class Register {
    private static final ICalculator taxCalculator = new TaxCalculator();
    private static final ICalculator importDutyCalculator = new ImportDutyCalculator();
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");
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
        total += Math.round((product.getPrice() + calculateProductFees(product)) * 100.0) / 100.0;
    }

    public static double calculateProductFees(IProduct product) {
        double productPrice = product.getPrice();

        if(product.isImported() && product.isTaxable()) {
            return  taxCalculator.calculate(productPrice) + importDutyCalculator.calculate(productPrice);
        } else if(product.isTaxable()){
            return taxCalculator.calculate(productPrice);
        } else if(product.isImported()) {
            return importDutyCalculator.calculate(productPrice);
        } else {
            return 0.0;
        }
    }

    public static List<IProduct> getProducts() {
        return products;
    }

    public static String getSubtotal() {
        return decimalFormat.format(subtotal);
    }

    public static double getTax() {
        double tax = Math.round((total - subtotal) * 100.0) / 100.0;
        return tax;
    }

    public static String getTotal() {
        return decimalFormat.format(total);
    }
}