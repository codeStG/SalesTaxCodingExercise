package products.impl;

import org.junit.jupiter.api.Test;
import checkout.Register;
import products.impl.NonTaxableItem;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class NonTaxableItemTest {
    Register testRegister = new Register(0.1, 0.05);

    @Test
    public void testNonTaxableImportedItemsBeingTaxedProperly() {
        NonTaxableItem testItem = new NonTaxableItem("Box of Chocolates", 10.00, true, testRegister);

        assertEquals(0.50, testItem.getItemTax());
    }

    @Test
    public void testNonTaxableNonImportedItemsBeingTaxedProperly() {
        NonTaxableItem testItem = new NonTaxableItem("Book", 12.49, false, testRegister);

        assertEquals(0.0, testItem.getItemTax());
    }

}
