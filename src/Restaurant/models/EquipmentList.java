package Restaurant.models;

import java.util.List;

public class EquipmentList {
    private List<Equipment> equipment;

    public List<Equipment> getEquipments() {
        return equipment;
    }

    public void setVisitorsOrders(List<Equipment> visitors_orders) {
        this.equipment = visitors_orders;
    }
}
