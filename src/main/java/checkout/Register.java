package checkout;

import products.Product;
import utilities.impl.PriceCalculator;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private final List<Product> shoppingCart = new ArrayList<>();

    public void scan(Product product) {
        shoppingCart.add(product);
    }

    public Receipt checkout() {
        return submitTransaction();
    }

    private Receipt submitTransaction() {
        Receipt receipt = new Receipt(getShoppingCart(), getSubtotal(), getTotal(), getTaxesAndDuties());
        clearRegister();
        return receipt;
    }

    private void clearRegister() {
        shoppingCart.clear();
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public double getSubtotal() {
        return new PriceCalculator(getShoppingCart()).calculateSubTotal();
    }

    public double getTaxesAndDuties() {
        return new PriceCalculator(getShoppingCart()).calculateAllFees();
    }

    public double getTotal() {
        return new PriceCalculator(getShoppingCart()).calculateTotal();
    }
}