package Restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class ProductTypes {
    private List<ProductType> product_types;

    public List<ProductType> getProductTypes() {
        return product_types;
    }

    public void setOperations(ArrayList<ProductType> operations) {
        this.product_types = operations;
    }
    public void addElement(ProductType element) {
        this.product_types.add(element);
    }
}
