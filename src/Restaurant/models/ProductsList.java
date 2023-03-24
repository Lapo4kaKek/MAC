package Restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class ProductsList {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> new_products) {
        this.products = new_products;
    }
}
