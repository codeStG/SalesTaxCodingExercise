package checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.Product;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {

    @Test
    public void testRegisterResetSetsZeroValues() {
        Register register = new Register();
        
        register.scan(new Product("Perfume", 47.50, true, true));
        register.scan(new Product("Book", 12.49, false, false));

        register.checkout();

        assertEquals(0, register.getSubtotal());
        assertEquals(0, register.getTotal());
    }

    @Test
    public void testAccuracyOfRegisterTotal() {
        Register register = new Register();

        register.scan(new Product("Book", 12.49, false, false));
        register.scan(new Product("Music CD", 14.99, false, true));
        register.scan(new Product("Chocolate Bar", 0.85, false, false));

        assertEquals(29.83, register.getTotal());
    }

    @Test
    public void testAccuracyOfRegisterSubtotal() {
        Register register = new Register();

        register.scan(new Product("Box of Chocolates", 10.00, true, false));
        register.scan(new Product("Bottle of Perfume", 47.50, true, true));

        assertEquals(57.5, register.getSubtotal());
    }
}
