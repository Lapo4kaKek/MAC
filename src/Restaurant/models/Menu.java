package Restaurant.models;

import java.util.ArrayList;

public class Menu {
    private static Menu instance_;
    private ArrayList<DishCard> list_;

    private Menu(ArrayList<DishCard> list) {
        list_ = list;
    }

    public static Menu getInstance(ArrayList<DishCard> list) {
        if (instance_ == null) {
            instance_ = new Menu(list);
        } else {
            instance_.updateMenu(list);
        }
        return instance_;
    }

    private void updateMenu(ArrayList<DishCard> new_list) {
        list_ = new_list;
    }

    public void deleteDish(DishCard dish) {
        for (DishCard element : list_) {
            if (element.getDishName().equals(dish.getDishName())) {
                list_.remove(dish);
                break;
            }
        }
    }

    public void addDish(DishCard dish) {
        list_.add(dish);
    }
}