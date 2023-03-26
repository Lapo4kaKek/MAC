package Restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class ProductsList {
    private List<IProductComponent> list_;

    public ProductsList() {
        list_ = new ArrayList<>();
    }

    public void addComponent(IProductComponent component) {
        list_.add(component);
    }

    public void removeComponent(IProductComponent component) {
        list_.remove(component);
    }

    public List<IProductComponent> getComponents() {
        return list_;
    }

    //@Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    //@Override
    public Integer getId() {
        throw new UnsupportedOperationException();
    }

    //@Override
    public Boolean isFood() {
        throw new UnsupportedOperationException();
    }

    //@Override
    public Integer getQuantity() {
        throw new UnsupportedOperationException();
    }

    //@Override
    public void updateQuantity(Integer new_quantity) {
        throw new UnsupportedOperationException();
    }

    //@Override
    public void pickUp(int count) {
        throw new UnsupportedOperationException();
    }
}
