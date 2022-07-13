package checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.Product;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {

    @BeforeEach
    public void clearOutRegister() {
        checkout();
    }

    @Test
    public void testRegisterResetSetsZeroValues() {
        scan(new Product("Perfume", 47.50, true, true));
        scan(new Product("Book", 12.49, false, false));

        checkout();

        assertEquals(0, getSubtotal());
        assertEquals(0, getTotal());
    }

    @Test
    public void testAccuracyOfRegisterTotal() {
        scan(new Product("Book", 12.49, false, false));
        scan(new Product("Music CD", 14.99, false, true));
        scan(new Product("Chocolate Bar", 0.85, false, false));

        assertEquals(29.83, getTotal());
    }

    @Test
    public void testAccuracyOfRegisterSubtotal() {
        scan(new Product("Box of Chocolates", 10.00, true, false));
        scan(new Product("Bottle of Perfume", 47.50, true, true));

        assertEquals(57.5, getSubtotal());
    }
}
