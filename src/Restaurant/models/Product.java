package Restaurant.models;

import com.google.gson.annotations.SerializedName;

public class Product implements IProductComponent {
    //@SerializedName(value = "name_", alternate = {"product_name"})
    private String name_;
    //@SerializedName(value = "name", alternate = {"product_name"})
    private Boolean isFood_;
    //@SerializedName(value = "name", alternate = {"product_name"})
    private Integer id_;
    //@SerializedName(value = "name", alternate = {"product_name"})
    private Integer quantity_;

    public Product(String name, Boolean isFood, Integer id, Integer quantity) {
        name_ = name;
        isFood_ = isFood;
        id_ = id;
        quantity_ = quantity;
    }

    public String getName() {
        return name_;
    }
    public Integer getId() {
        return id_;
    }
    public Boolean isFood() {
        return isFood_;
    }
    public Integer getQuantity() {
        return quantity_;
    }
    public void updateQuantity(Integer new_quantity) {
        quantity_ = new_quantity;
    }
    public void pickUp(int count) {
        if (count > 0 && quantity_ >= count) {
            quantity_ -= count;
        } else {
            // тут что-то
        }
    }
}
