import checkout.Receipt;
import products.Product;

import checkout.Register;

public class Main {

    public static void main(String[] args) {
        Register register = new Register();

        register.scan(new Product("Book", 12.49, false, false));
        register.scan(new Product("Music CD", 14.99, false, true));
        register.scan(new Product("Chocolate Bar", 0.85, false, false));
        Receipt receipt = register.checkout();
        System.out.println(receipt.toString());

        register.scan(new Product("Box of Chocolates", 10.00, true, false));
        register.scan(new Product("Perfume", 47.50, true, true));
        Receipt receipt2 = register.checkout();
        System.out.println(receipt2.toString());

        register.scan(new Product("Bottle of Perfume", 27.99, true, true));
        register.scan(new Product("Bottle of Perfume", 18.99, false, true));
        register.scan(new Product("Headache Pills", 9.75, false, false));
        register.scan(new Product("Box of Chocolates", 11.25, true, false));
        Receipt receipt3 = register.checkout();
        System.out.println(receipt3.toString());
    }
}