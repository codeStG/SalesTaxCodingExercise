package checkout;

import products.Product;
import utilities.impl.PriceCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Product> shoppingCart;
    private final double subtotal;
    private final double total;
    private final double taxesAndDuties;
    private final DecimalFormat decimalFormatter= new DecimalFormat("#.00");

    public Receipt(List<Product> shoppingCart, double subtotal, double total, double taxesAndDuties) {
        this.shoppingCart = new ArrayList<>(shoppingCart);
        this.subtotal = subtotal;
        this.total = total;
        this.taxesAndDuties = taxesAndDuties;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public double getTaxesAndDuties() {
        return taxesAndDuties;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Product product : getShoppingCart()) {
            stringBuilder
                    .append(product.getName())
                    .append("\n\t\t\t\t\t")
                    .append(decimalFormatter.format(new PriceCalculator(product).calculateTotal()))
                    .append("\n--------------------------\n");
        }

        stringBuilder
                .append("\nSubtotal: \t\t\t")
                .append(decimalFormatter.format(getSubtotal()))
                .append("\nTax: \t\t\t\t")
                .append(decimalFormatter.format(getTaxesAndDuties()))
                .append("\nTotal: \t\t\t\t")
                .append(decimalFormatter.format(getTotal()))
                .append("\n");


        return stringBuilder.toString();
        }

//        System.out.println("\nSubtotal: \t\t\t" + decimalFormatter.format(register.getSubtotal()));
//        System.out.println("Tax: \t\t\t\t" + decimalFormatter.format(register.getTaxesAndDuties()));
//        System.out.println("Total: \t\t\t\t" + decimalFormatter.format(register.getTotal()));
//        System.out.println();

    //    private final DecimalFormat decimalFormatter = new DecimalFormat("#.00");
//
//    private Register register = new Register();
//
//    public void print() {
//        generateProductLines();
//        System.out.println("\nSubtotal: \t\t\t" + decimalFormatter.format(register.getSubtotal()));
//        System.out.println("Tax: \t\t\t\t" + decimalFormatter.format(register.getTaxesAndDuties()));
//        System.out.println("Total: \t\t\t\t" + decimalFormatter.format(register.getTotal()));
//        System.out.println();
//    }
//
//    private void generateProductLines() {
//        for (Product product : register.getShoppingCart()) {
//            System.out.println(product.getName());
//            System.out.println("\t\t\t\t\t" + decimalFormatter.format(register.getSingleProductTotal(product)));
//            System.out.println("--------------------------");
//        }
//    }
}