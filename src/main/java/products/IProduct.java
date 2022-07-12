package products;

public interface IProduct {
    String getName();

    double getPrice();

    double getPriceWithFees();

    boolean isImported();

    boolean isTaxable();
}
