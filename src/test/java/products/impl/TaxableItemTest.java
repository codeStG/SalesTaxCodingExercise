package products.impl;

import org.junit.jupiter.api.Test;
import checkout.Register;
import products.impl.TaxableItem;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TaxableItemTest {

    @Test
    public void testTaxableImportedItemsBeingTaxedProperly() {
        Register testRegister = new Register(0.1, 0.05);
        TaxableItem testItem = new TaxableItem("Perfume", 47.50, true, testRegister);

        assertEquals(7.15, testItem.getItemTax());
    }

    @Test
    public void testTaxableNonImportedItemsBeingTaxedProperly() {
        Register testRegister = new Register(0.1, 0.05);
        TaxableItem testItem = new TaxableItem("Music CD", 14.99, false, testRegister);

        assertEquals(1.50, testItem.getItemTax());
    }
}
