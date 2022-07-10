package checkout;

import products.impl.Item;

import java.util.List;

public class Receipt {
    private final List<Item> items;
    private final double subtotal;
    private final double total;

    public Receipt(List<Item> items, double subtotal, double total) {
        this.items = items;
        this.subtotal = subtotal;
        this.total = total;
    }

    public double getSubtotal() {
        return Math.round(subtotal * 100.0) / 100.0;
    }

    public double getTotal() {
        return Math.round(total * 100.0) / 100.0;
    }

    public double getTax() {
        double tax = Math.round((getTotal() - getSubtotal()) * 100.0) / 100.0;
        return tax;
    }

    public void print() {
        for(Item item : items) {
            System.out.println(item.getName());
            System.out.println("\t\t\t\t\t" + Math.round((item.getPrice() + item.getItemTax()) * 100.0) / 100.0);
            System.out.println("--------------------------");
        }
        System.out.println("\nSubtotal: \t\t\t" + getSubtotal());
        System.out.println("Tax: \t\t\t\t" + getTax());
        System.out.println("Total: \t\t\t\t" + getTotal());
        System.out.println();
    }
}
