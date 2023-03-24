package Restaurant.models;

public class MenuDish {
    private int menu_dish_id;
    private int menu_dish_card;
    private int menu_dish_price;
    private boolean menu_dish_active;

    public int getMenuDishId() {
        return menu_dish_id;
    }

    public void setMenuDishId(int menu_dish_id) {
        this.menu_dish_id = menu_dish_id;
    }

    public int getMenuDishCard() {
        return menu_dish_card;
    }

    public void setMenuDishCard(int menu_dish_card) {
        this.menu_dish_card = menu_dish_card;
    }

    public int getMenuDishPrice() {
        return menu_dish_price;
    }

    public void setMenuDishPrice(int menu_dish_price) {
        this.menu_dish_price = menu_dish_price;
    }

    public boolean isMenuDishActive() {
        return menu_dish_active;
    }

    public void setMenuDishActive(boolean menu_dish_active) {
        this.menu_dish_active = menu_dish_active;
    }
}

