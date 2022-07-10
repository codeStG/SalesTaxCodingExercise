package products;

import products.impl.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int itemNumber) {
        items.remove(itemNumber - 1);
    }

    public List<Item> getItems() {
        return items;
    }
}
