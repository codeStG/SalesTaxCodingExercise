package checkout;

import org.junit.jupiter.api.Test;
import checkout.Register;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
    Register testRegister = new Register(0.1, 0.05);

    @Test
    public void testRegisterResetSetsZeroValues() {
        testRegister.scan(new TaxableItem("Perfume", 47.50, true, testRegister));
        testRegister.scan(new NonTaxableItem("Book", 12.49, false, testRegister));

        testRegister.reset();
        assertEquals(0, testRegister.getSubtotal());
        assertEquals(0, testRegister.getTotal());
    }

    @Test
    public void testAccuracyOfRegisterTotal() {
        testRegister.scan(new NonTaxableItem("Book", 12.49, false, testRegister));
        testRegister.scan(new TaxableItem("Music CD", 14.99, false, testRegister));
        testRegister.scan(new NonTaxableItem("Chocolate Bar", 0.85, false, testRegister));

        assertEquals(29.83, testRegister.getTotal());
    }

    @Test
    public void testAccuracyOfRegisterSubtotal() {
        testRegister.scan(new NonTaxableItem("Box of Chocolates", 10.00, true, testRegister));
        testRegister.scan(new TaxableItem("Bottle of Perfume", 47.50, true, testRegister));

        assertEquals(57.5, testRegister.getSubtotal());
    }
}
