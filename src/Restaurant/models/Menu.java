package Restaurant.models;

import java.util.ArrayList;

public class Menu {
    ArrayList<Dish_cards> list_;
    public Menu(ArrayList<Dish_cards> list) {
        list_ = list;
    }
    public void updateMenu(ArrayList<Dish_cards> new_list) {
        list_ = new_list;
    }
    public void deleteDish(Dish_cards dish) {
        for (Dish_cards element : list_) {
            if (element.getName().equals(dish.getName())) {
                list_.remove(dish);
                break;
            }
        }
    }
    public void addDish(Dish_cards dish) {
        list_.add(dish);
    }

}
