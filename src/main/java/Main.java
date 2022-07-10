import checkout.Register;
import checkout.Receipt;
import products.ShoppingCart;
import products.impl.Item;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Register register = new Register(0.1, 0.05);
        ShoppingCart cartOne = new ShoppingCart();

        cartOne.addItem(new NonTaxableItem("Book", 12.49, false, register));
        cartOne.addItem(new TaxableItem("Music CD", 14.99, false, register));
        cartOne.addItem(new NonTaxableItem("Chocolate Bar", 0.85, false, register));

        register.reset();

        List<Item> itemsInCart = cartOne.getItems();
        for(Item item : itemsInCart){
            register.scan(item);
        }

        Receipt receipt = register.submit(itemsInCart);
        receipt.print();

        ShoppingCart cartTwo = new ShoppingCart();

        cartTwo.addItem(new NonTaxableItem("Box of Chocolates", 10.00, true, register));
        cartTwo.addItem(new TaxableItem("Perfume", 47.50, true, register));

        register.reset();
        itemsInCart = cartTwo.getItems();

        for(Item item : itemsInCart) {
            register.scan(item);
        }

        receipt = register.submit(itemsInCart);
        receipt.print();

        ShoppingCart cartThree = new ShoppingCart();

        cartThree.addItem(new TaxableItem("Bottle of Perfume", 27.99, true, register));
        cartThree.addItem(new TaxableItem("Bottle of Perfume", 18.99, false, register));
        cartThree.addItem(new NonTaxableItem("Headache Pills", 9.75, false, register));
        cartThree.addItem(new NonTaxableItem("Box of Chocolates", 11.25, true, register));

        register.reset();
        itemsInCart = cartThree.getItems();

        for(Item item : itemsInCart) {
            register.scan(item);
        }

        receipt = register.submit(itemsInCart);
        receipt.print();

    }

}
