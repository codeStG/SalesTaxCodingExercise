package products;

import org.junit.jupiter.api.Test;
import checkout.Register;
import products.ShoppingCart;
import products.impl.Item;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    Register testRegister = new Register(0.1, 0.05);
    ShoppingCart testCart = new ShoppingCart();
    Item testItem1 = new NonTaxableItem("Book", 12.49, false, testRegister);
    Item testItem2 = new TaxableItem("Perfume", 47.50, true, testRegister);
    Item testItem3 = new NonTaxableItem("Box of Chocolates", 10.00, true, testRegister);

    @Test
    public void testAbilityToAddItems() {
        testCart.addItem(testItem1);
        testCart.addItem(testItem2);
        testCart.addItem(testItem3);
        assertEquals(3, testCart.getItems().size());
    }

    @Test
    public void testAbilityToRemoveItems() {
        ShoppingCart testCart2 = new ShoppingCart();
        testCart.addItem(testItem1);
        testCart.addItem(testItem2);
        testCart.addItem(testItem3);

        testCart2.addItem(testItem1);
        testCart2.addItem(testItem2);

        testCart.removeItem(3);

        System.out.println(testCart2.getItems());
        System.out.println(testCart.getItems());


        assertEquals(true, testCart2.getItems().equals(testCart.getItems()));
    }
}
