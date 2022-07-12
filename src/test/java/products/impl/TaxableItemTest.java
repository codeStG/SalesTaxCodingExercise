package products.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxableItemTest {

    @BeforeEach
    public void clearOutRegister() {
        checkout();
    }

    @Test
    public void testTaxableImportedItemsBeingTaxedProperly() {
        scan(new TaxableItem("Perfume", 47.50, true));

        assertEquals(7.15, getTax());
    }

    @Test
    public void testTaxableNonImportedItemsBeingTaxedProperly() {
        scan(new TaxableItem("Music CD", 14.99, false));

        assertEquals(1.50, getTax());
    }
}
