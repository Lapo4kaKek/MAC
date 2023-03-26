package models;

import java.util.List;

public class EquipmentTypeList {
    private List<EquipmentType> equipment_type;

    public List<EquipmentType> getVisitorsOrders() {
        return equipment_type;
    }

    public void setVisitorsOrders(List<EquipmentType> visitors_orders) {
        this.equipment_type = visitors_orders;
    }
}
