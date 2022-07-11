package products.impl;

import checkout.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import checkout.Register;
import products.impl.NonTaxableItem;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class NonTaxableItemTest {

    @BeforeEach
    public void clearOutRegister() {
        reset();
    }

    @Test
    public void testNonTaxableImportedItemsBeingTaxedProperly() {
        scan(new NonTaxableItem("Box of Chocolates", 10.00, true));

        Receipt receipt = submit();

        assertEquals(0.50, receipt.getTax());
    }

    @Test
    public void testNonTaxableNonImportedItemsBeingTaxedProperly() {
        scan(new NonTaxableItem("Book", 12.49, false));

        Receipt receipt = submit();

        assertEquals(0.0, receipt.getTax());
    }

}
