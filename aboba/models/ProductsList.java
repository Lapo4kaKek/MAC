package models;

import java.util.ArrayList;

public class ProductsList {
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> new_products) {
        this.products = new_products;
    }
}
