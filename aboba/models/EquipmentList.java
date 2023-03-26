package models;

import java.util.List;

public class EquipmentList {
    private List<Equipment> equipment;

    public List<Equipment> getVisitorsOrders() {
        return equipment;
    }

    public void setVisitorsOrders(List<Equipment> visitors_orders) {
        this.equipment = visitors_orders;
    }
}
