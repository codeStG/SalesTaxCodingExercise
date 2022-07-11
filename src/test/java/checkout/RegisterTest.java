package checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {

    @BeforeEach
    public void clearOutRegister() {
        reset();
    }

    @Test
    public void testRegisterResetSetsZeroValues() {
        scan(new TaxableItem("Perfume", 47.50, true));
        scan(new NonTaxableItem("Book", 12.49, false));

        reset();

        assertEquals(0, getSubtotal());
        assertEquals(0, getTotal());
    }

    @Test
    public void testAccuracyOfRegisterTotal() {
        scan(new NonTaxableItem("Book", 12.49, false));
        scan(new TaxableItem("Music CD", 14.99, false));
        scan(new NonTaxableItem("Chocolate Bar", 0.85, false));

        assertEquals(29.83, getTotal());
    }

    @Test
    public void testAccuracyOfRegisterSubtotal() {
        scan(new NonTaxableItem("Box of Chocolates", 10.00, true));
        scan(new TaxableItem("Bottle of Perfume", 47.50, true));

        assertEquals(57.5, getSubtotal());
    }
}
