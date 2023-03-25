package Restaurant.models;

public interface IProductComponent {
    String getName();
    Integer getId();
    Boolean isFood();
    Integer getQuantity();
    void updateQuantity(Integer new_quantity);
    void pickUp(int count);
}