package products.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonTaxableItemTest {

    @BeforeEach
    public void clearOutRegister() {
        checkout();
    }

    @Test
    public void testNonTaxableImportedItemsBeingTaxedProperly() {
        scan(new NonTaxableItem("Box of Chocolates", 10.00, true));

        assertEquals(0.50, getTax());
    }

    @Test
    public void testNonTaxableNonImportedItemsBeingTaxedProperly() {
        scan(new NonTaxableItem("Book", 12.49, false));

        assertEquals(0.0, getTax());
    }
}
