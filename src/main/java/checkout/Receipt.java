package checkout;

import products.Product;

import java.text.DecimalFormat;

import static checkout.Register.*;

public class Receipt {

    private static final DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    public static void print() {
        generateProductLines();
        System.out.println("\nSubtotal: \t\t\t" + decimalFormatter.format(getSubtotal()));
        System.out.println("Tax: \t\t\t\t" + decimalFormatter.format(getTaxesAndDuties()));
        System.out.println("Total: \t\t\t\t" + decimalFormatter.format(getTotal()));
        System.out.println();
    }

    private static void generateProductLines() {
        for(Product product : getShoppingCart()) {
            System.out.println(product.getName());
            System.out.println("\t\t\t\t\t" + decimalFormatter.format(product.getPriceWithFees()));
            System.out.println("--------------------------");
        }
    }
}
