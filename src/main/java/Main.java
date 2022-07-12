import products.impl.NonTaxableItem;
import products.impl.TaxableItem;

import static checkout.Register.*;

public class Main {

    public static void main(String[] args) {
        scan(new NonTaxableItem("Book", 12.49, false));
        scan(new TaxableItem("Music CD", 14.99, false));
        scan(new NonTaxableItem("Chocolate Bar", 0.85, false));
        submit();
        reset();

        scan(new NonTaxableItem("Box of Chocolates", 10.00, true));
        scan(new TaxableItem("Perfume", 47.50, true));
        submit();
        reset();

        scan(new TaxableItem("Bottle of Perfume", 27.99, true));
        scan(new TaxableItem("Bottle of Perfume", 18.99, false));
        scan(new NonTaxableItem("Headache Pills", 9.75, false));
        scan(new NonTaxableItem("Box of Chocolates", 11.25, true));
        submit();
        reset();
    }
}
