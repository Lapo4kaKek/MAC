package Restaurant.models;

import java.sql.Time;
import java.util.ArrayList;
public class Operation {
     private Integer type_;
     private ArrayList<Product> products_;
     private Time time_;
     public Operation(Integer type, ArrayList<Product> products) {
         products_ = products;
         type_ = type;
     }
    public Operation(Integer type, ArrayList<Product> products, Time time) {
        products_ = products;
        type_ = type;
        time_ = time;
    }
     public Integer getType() {
         return type_;
     }
     public ArrayList<Product> getProducts() {
         return products_;
     }
     public Time getTime() {
         return time_;
     }
}
