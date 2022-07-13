import checkout.Register;
import org.junit.jupiter.api.Test;
import products.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    
    @Test
    public void testRegisterRecordsAccurateTax() {
        Register register = new Register();
        
        register.scan(new Product("Lord of the Rings, the 2 towers", 12.49, false, false));
        register.scan(new Product("Music CD", 14.99, false, true));
        register.scan(new Product("Chocolate Bar", 0.85, false, false));

        assertEquals(1.50, register.getTaxesAndDuties());
    }

    @Test
    public void testRegisterRecordsAccurateTotal() {
        Register register = new Register();
        register.scan(new Product("Lord of the Rings, the 2 towers", 12.49, false, false));
        register.scan(new Product("Music CD", 14.99, false, true));
        register.scan(new Product("Chocolate Bar", 0.85, false, false));

        assertEquals(29.83, register.getTotal());
    }
}