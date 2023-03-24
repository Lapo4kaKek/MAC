package Restaurant.models;

public class VisOrdDish {
    private int ord_dish_id;
    private int menu_dish;

    public VisOrdDish() {}

    public int getOrdDishId() {
        return ord_dish_id;
    }

    public void setOrdDishId(int ord_dish_id) {
        this.ord_dish_id = ord_dish_id;
    }

    public int getMenuDish() {
        return menu_dish;
    }

    public void setMenuDish(int menu_dish) {
        this.menu_dish = menu_dish;
    }
}