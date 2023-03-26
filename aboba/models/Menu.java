package models;

import java.util.ArrayList;

public class Menu {
    ArrayList<DishCard> list_;
    public Menu(ArrayList<DishCard> list) {
        list_ = list;
    }
    public void updateMenu(ArrayList<DishCard> new_list) {
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
