import checkout.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @BeforeEach
    public void clearOutRegister() {
        reset();
    }

    @Test
    public void testReceiptRecordsAccurateTax() {
        scan(new NonTaxableItem("Lord of the Rings, the 2 towers", 12.49, false));
        scan(new TaxableItem("Music CD", 14.99, false));
        scan(new NonTaxableItem("Chocolate Bar", 0.85, false));

        Receipt receipt = submit();
        assertEquals(1.50, receipt.getTax());
    }

    @Test
    public void testReceiptRecordsAccurateTotal() {
        scan(new NonTaxableItem("Lord of the Rings, the 2 towers", 12.49, false));
        scan(new TaxableItem("Music CD", 14.99, false));
        scan(new NonTaxableItem("Chocolate Bar", 0.85, false));

        Receipt receipt = submit();
        assertEquals(29.83, receipt.getTotal());
    }
}
