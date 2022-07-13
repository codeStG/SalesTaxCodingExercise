package checkout;

import products.Product;
import utilities.ICalculator;
import utilities.impl.SubTotalCalculator;
import utilities.impl.TaxesAndDutiesCalculator;
import utilities.impl.TotalCalculator;

import java.util.ArrayList;
import java.util.List;

import static checkout.Receipt.print;

public class Register {
    private static final ICalculator taxesAndDutiesCalculator = new TaxesAndDutiesCalculator();
    private static final ICalculator subtotalCalculator = new SubTotalCalculator();
    private static final ICalculator totalCalculator = new TotalCalculator();
    private static final List<Product> shoppingCart = new ArrayList<>();
    private static double subtotal = 0;
    private static double taxesAndDuties = 0;
    private static double total = 0;

    public static void scan(Product product) {
        shoppingCart.add(product);
        calculateSubtotal(product);
        calculateTaxesAndDuties(product);
        calculateTotal(product);
    }

    private static void calculateSubtotal(Product product) {
        subtotal += subtotalCalculator.calculate(product);
    }

    private static void calculateTaxesAndDuties(Product product) {
        taxesAndDuties += taxesAndDutiesCalculator.calculate(product);
    }

    private static void calculateTotal(Product product) {
        total += totalCalculator.calculate(product);
    }

    public static void checkout() {
        submitTransaction();
        clearRegister();
    }

    private static void clearRegister() {
        subtotal = 0;
        taxesAndDuties = 0;
        total = 0;
        shoppingCart.clear();
    }

    private static void submitTransaction() {
        print();
    }

    public static List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public static double getSubtotal() {
        return subtotal;
    }

    public static double getTaxesAndDuties() {
        return taxesAndDuties;
    }

    public static double getTotal() {
        return total;
    }
}