package checkout;

import products.IProduct;
import static checkout.Register.*;

public class Receipt {

    public static void print() {
        for(IProduct product : getProducts()) {
            System.out.println(product.getName());
            System.out.println("\t\t\t\t\t" + Math.round((product.getPrice() + calculateItemTax(product)) * 100.0) / 100.0);
            System.out.println("--------------------------");
        }
        System.out.println("\nSubtotal: \t\t\t" + getSubtotal());
        System.out.println("Tax: \t\t\t\t" + getTax());
        System.out.println("Total: \t\t\t\t" + getTotal());
        System.out.println();
    }
}
