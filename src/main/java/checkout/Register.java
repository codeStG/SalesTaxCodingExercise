package checkout;

import products.IProduct;
import utilities.ICalculator;
import utilities.impl.ImportDutyCalculator;
import utilities.impl.TaxCalculator;

import java.util.ArrayList;
import java.util.List;

import static checkout.Receipt.print;

public class Register {
    private static final ICalculator taxCalculator = new TaxCalculator();
    private static final ICalculator importDutyCalculator = new ImportDutyCalculator();
    private static final List<IProduct> shoppingCart = new ArrayList<>();
    private static double subtotal = 0;
    private static double total = 0;

    public static void scan(IProduct product) {
        shoppingCart.add(product);
        calculateTotal(product);
    }

    private static void calculateTotal(IProduct product) {
        subtotal += Math.round(product.getPrice() * 100.0) / 100.0;
        total += Math.round((product.getPrice() + calculateProductFees(product)) * 100.0) / 100.0;
    }

    public static void checkout() {
        submitTransaction();
        clearRegister();
    }

    private static void clearRegister() {
        subtotal = 0;
        total = 0;
        shoppingCart.clear();
    }

    private static void submitTransaction() {
        print();
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

    public static List<IProduct> getShoppingCart() {
        return shoppingCart;
    }

    public static double getSubtotal() {
        return subtotal;
    }

    public static double getTax() {
        return Math.round((total - subtotal) * 100.0) / 100.0;
    }

    public static double getTotal() {
        return total;
    }
}