import products.Product;

import static checkout.Register.checkout;
import static checkout.Register.scan;

public class Main {

    public static void main(String[] args) {
        scan(new Product("Book", 12.49, false, false));
        scan(new Product("Music CD", 14.99, false, true));
        scan(new Product("Chocolate Bar", 0.85, false, false));
        checkout();

        scan(new Product("Box of Chocolates", 10.00, true, false));
        scan(new Product("Perfume", 47.50, true, true));
        checkout();

        scan(new Product("Bottle of Perfume", 27.99, true, true));
        scan(new Product("Bottle of Perfume", 18.99, false, true));
        scan(new Product("Headache Pills", 9.75, false, false));
        scan(new Product("Box of Chocolates", 11.25, true, false));
        checkout();
    }
}
