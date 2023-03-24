package Restaurant.models;

import java.sql.Time;
import java.util.ArrayList;


public class Dish_cards {
    private String name_;
    private String id_;
    private Time time_;
    private Integer type_;
    private ArrayList<Operation> operations;
    public String getName() {
        return name_;
    }
    public String getId() {
        return id_;
    }
    public Integer getType() {
        return type_;
    }
    public Time getTime() {
        return time_;
    }
}
