package checkout;

import org.junit.jupiter.api.Test;
import checkout.Receipt;
import checkout.Register;
import products.ShoppingCart;
import products.impl.Item;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    Register testRegister = new Register(0.10, 0.05);
    ShoppingCart testCart = new ShoppingCart();
    Receipt testReceipt;

    @Test
    public void testAccuracyOfReceiptTotal() {
        testCart.addItem(new NonTaxableItem("Book", 12.49, false, testRegister));
        testCart.addItem(new TaxableItem("Music CD", 14.99, false, testRegister));
        testCart.addItem(new NonTaxableItem("Chocolate Bar", 0.85, false, testRegister));

        List<Item> itemsInCart = testCart.getItems();
        for (Item i : itemsInCart) {
            testRegister.scan(i);
        }

        testReceipt = testRegister.submit(testCart.getItems());

        assertEquals(29.83, testReceipt.getTotal());
    }

    @Test
    public void testAccuracyOfReceiptSubtotal() {
        testCart.addItem(new NonTaxableItem("Box of Chocolates", 10.00, true, testRegister));
        testCart.addItem(new TaxableItem("Bottle of Perfume", 47.50, true, testRegister));

        List<Item> itemsInCart = testCart.getItems();
        for (Item i : itemsInCart) {
            testRegister.scan(i);
        }

        testReceipt = testRegister.submit(testCart.getItems());

        assertEquals(57.50, testReceipt.getSubtotal());
    }

    @Test
    public void testAccuracyOfReceiptTax() {
        testCart.addItem(new TaxableItem("Bottle of Perfume", 27.99, true, testRegister));
        testCart.addItem(new TaxableItem("Bottle of Perfume", 18.99, false, testRegister));
        testCart.addItem(new NonTaxableItem("Headache Pills", 9.75, false, testRegister));
        testCart.addItem(new NonTaxableItem("Box of Chocolates", 11.25, true, testRegister));
        List<Item> itemsInCart = testCart.getItems();
        for (Item i : itemsInCart) {
            testRegister.scan(i);
        }
        testReceipt = testRegister.submit(testCart.getItems());
        System.out.println(testReceipt.getTax());
        assertEquals(6.70, testReceipt.getTax());
    }
}
