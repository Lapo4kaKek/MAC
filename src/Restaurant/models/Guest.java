package Restaurant.models;

import java.sql.Time;
import java.util.ArrayList;

public class Guest {
    private String vis_name;
    private Time vis_ord_started;
    private Time vis_ord_ended;
    private Integer vis_ord_total;
    private ArrayList<DishCard> vis_ord_dishes;
    private Time cooking_time_;
    private Integer list_id_;
    public Guest(String name, Time start, Time end, Integer total) {
        vis_name = name;
        vis_ord_started = start;
        vis_ord_ended = end;
        vis_ord_total = total;
    }
    public Guest() {};
    public void SelectDish(ArrayList<DishCard> dishes, Integer id) {
        vis_ord_dishes = dishes;
        list_id_ = id;
    }
    public void updateCookingTime(Time cooking_time) {
        if (cooking_time.getSeconds() > 0) {
            cooking_time_ = cooking_time;
        }
    }
    public void addDish(DishCard dish) {
        vis_ord_dishes.add(dish);
    }

}
