package products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxableProductTest {

    @BeforeEach
    public void clearOutRegister() {
        checkout();
    }

    @Test
    public void testTaxableImportedItemsBeingTaxedProperly() {
        scan(new Product("Perfume", 47.50, true, true));

        assertEquals(7.15, getTaxesAndDuties());
    }

    @Test
    public void testTaxableNonImportedItemsBeingTaxedProperly() {
        scan(new Product("Music CD", 14.99, false, true));

        assertEquals(1.50, getTaxesAndDuties());
    }
}
