package utilities;

import products.Product;

public interface ImportDutiesCalculator {
    double IMPORT_DUTY = .05;

    double calculateImportDuties(double price);
}
