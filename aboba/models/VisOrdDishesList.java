package models;

import java.util.ArrayList;

public class VisOrdDishesList {
    private ArrayList<VisOrdDish> vis_order_dishes;

    public ArrayList<VisOrdDish> getVidOrderDishes() {
        return vis_order_dishes;
    }

    public void setOperations(ArrayList<VisOrdDish> operations) {
        this.vis_order_dishes = operations;
    }
    public void addElement(VisOrdDish element) {
        this.vis_order_dishes.add(element);
    }
}
