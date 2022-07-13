package products;

import checkout.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxableProductTest {

    @Test
    public void testTaxableImportedItemsBeingTaxedProperly() {
        Register register = new Register();

        register.scan(new Product("Perfume", 47.50, true, true));

        assertEquals(7.15, register.getTaxesAndDuties());
    }

    @Test
    public void testTaxableNonImportedItemsBeingTaxedProperly() {
        Register register = new Register();

        register.scan(new Product("Music CD", 14.99, false, true));

        assertEquals(1.50, register.getTaxesAndDuties());
    }
}
