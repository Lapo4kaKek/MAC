package models;

import java.util.List;

public class Guest {
    private String vis_name;
    private String vis_ord_started;
    private String vis_ord_ended;
    private Integer vis_ord_total;
    private List<VisOrdDish> vis_ord_dishes;

    public Guest(String name, String start, String end, Integer total) {
        vis_name = name;
        vis_ord_started = start;
        vis_ord_ended = end;
        vis_ord_total = total;
    }

    public Guest() {}

    public String getVisName() {
        return vis_name;
    }

    public void setVisName(String vis_name) {
        this.vis_name = vis_name;
    }

    public String getVisOrdStarted() {
        return vis_ord_started;
    }

    public void setVisOrdStarted(String vis_ord_started) {
        this.vis_ord_started = vis_ord_started;
    }

    public String getVisOrdEnded() {
        return vis_ord_ended;
    }

    public void setVisOrdEnded(String vis_ord_ended) {
        this.vis_ord_ended = vis_ord_ended;
    }

    public Integer getVisOrdTotal() {
        return vis_ord_total;
    }

    public void setVisOrdTotal(Integer vis_ord_total) {
        this.vis_ord_total = vis_ord_total;
    }

    public List<VisOrdDish> getVisOrdDishes() {
        return vis_ord_dishes;
    }

    public void setVisOrdDishes(List<VisOrdDish> vis_ord_dishes) {
        this.vis_ord_dishes = vis_ord_dishes;
    }
}