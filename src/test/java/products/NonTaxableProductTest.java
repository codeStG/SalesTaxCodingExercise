package products;

import checkout.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonTaxableProductTest {

    @Test
    public void testNonTaxableImportedItemsBeingTaxedProperly() {
        Register register = new Register();

        register.scan(new Product("Box of Chocolates", 10.00, true, false));

        assertEquals(0.50, register.getTaxesAndDuties());
    }

    @Test
    public void testNonTaxableNonImportedItemsBeingTaxedProperly() {
        Register register = new Register();

        register.scan(new Product("Book", 12.49, false, false));

        assertEquals(0.0, register.getTaxesAndDuties());
    }
}
