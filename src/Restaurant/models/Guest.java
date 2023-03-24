package Restaurant.models;

import java.sql.Time;
import java.util.ArrayList;

public class Guest {
    private String name_;
    private Time started_;
    private Time end_;
    private Integer total_;
    private ArrayList<Dish_cards> list_;
    private Time cooking_time_;
    private Integer list_id_;
    public Guest(String name, Time start, Time end, Integer total) {
        name_ = name;
        started_ = start;
        end_ = end;
        total_ = total;
    }
    public void SelectDish(ArrayList<Dish_cards> dishes, Integer id) {
        list_ = dishes;
        list_id_ = id;
    }
    public void updateCookingTime(Time cooking_time) {
        if (cooking_time.getSeconds() > 0) {
            cooking_time_ = cooking_time;
        }
    }

}
