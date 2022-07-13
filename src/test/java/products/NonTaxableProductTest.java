package products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonTaxableProductTest {

    @BeforeEach
    public void clearOutRegister() {
        checkout();
    }

    @Test
    public void testNonTaxableImportedItemsBeingTaxedProperly() {
        scan(new Product("Box of Chocolates", 10.00, true, false));

        assertEquals(0.50, getTaxesAndDuties());
    }

    @Test
    public void testNonTaxableNonImportedItemsBeingTaxedProperly() {
        scan(new Product("Book", 12.49, false, false));

        assertEquals(0.0, getTaxesAndDuties());
    }
}
