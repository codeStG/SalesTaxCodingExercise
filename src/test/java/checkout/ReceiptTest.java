package checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import static checkout.Register.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
//
//    @BeforeEach
//    public void clearOutRegister() {
//        reset();
//    }
//
//    @Test
//    public void testReceiptPrints() {
//        scan(new NonTaxableItem("Book", 12.49, false));
//        scan(new TaxableItem("Music CD", 14.99, false));
//        scan(new NonTaxableItem("Chocolate Bar", 0.85, false));
//
//        assertEquals(29.83, receipt.getTotal());
//    }
//
//    @Test
//    public void testAccuracyOfReceiptSubtotal() {
//        scan(new NonTaxableItem("Box of Chocolates", 10.00, true));
//        scan(new TaxableItem("Bottle of Perfume", 47.50, true));
//
//        Receipt receipt = submit();
//
//        assertEquals(57.50, receipt.getSubtotal());
//    }
//
//    @Test
//    public void testAccuracyOfReceiptTax() {
//        scan(new TaxableItem("Bottle of Perfume", 27.99, true));
//        scan(new TaxableItem("Bottle of Perfume", 18.99, false));
//        scan(new NonTaxableItem("Headache Pills", 9.75, false));
//        scan(new NonTaxableItem("Box of Chocolates", 11.25, true));
//
//        Receipt receipt = submit();
//
//        assertEquals(6.70, receipt.getTax());
//    }
}
