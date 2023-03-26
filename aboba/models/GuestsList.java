package models;

import java.util.List;

public class GuestsList {
    private List<Guest> visitors_orders;

    public List<Guest> getVisitorsOrders() {
        return visitors_orders;
    }

    public void setVisitorsOrders(List<Guest> visitors_orders) {
        this.visitors_orders = visitors_orders;
    }
}