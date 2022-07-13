import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.Product;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @BeforeEach
    public void clearOutRegister() {
        checkout();
    }

    @Test
    public void testRegisterRecordsAccurateTax() {
        scan(new Product("Lord of the Rings, the 2 towers", 12.49, false, false));
        scan(new Product("Music CD", 14.99, false, true));
        scan(new Product("Chocolate Bar", 0.85, false, false));

        assertEquals(1.50, getTaxesAndDuties());
    }

    @Test
    public void testRegisterRecordsAccurateTotal() {
        scan(new Product("Lord of the Rings, the 2 towers", 12.49, false, false));
        scan(new Product("Music CD", 14.99, false, true));
        scan(new Product("Chocolate Bar", 0.85, false, false));

        assertEquals(29.83, getTotal());
    }
}
