package models;

public class Product {
    private String name_;
    private Boolean isFood_;
    private Integer id_;
    public Integer quantity_;

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
