package Restaurant.models;

public interface IProductTypeComponent {
    void add(IProductTypeComponent component);
    void remove(IProductTypeComponent component);
    String getName();
    boolean isFood();
    int getId();
}