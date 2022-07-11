package products.impl;

import checkout.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import checkout.Register;
import products.impl.TaxableItem;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxableItemTest {

    @BeforeEach
    public void clearOutRegister() {
        reset();
    }

    @Test
    public void testTaxableImportedItemsBeingTaxedProperly() {
        scan(new TaxableItem("Perfume", 47.50, true));

        Receipt receipt = submit();

        assertEquals(7.15, receipt.getTax());
    }

    @Test
    public void testTaxableNonImportedItemsBeingTaxedProperly() {
        scan(new TaxableItem("Music CD", 14.99, false));

        Receipt receipt = submit();

        assertEquals(1.50, receipt.getTax());
    }
}
