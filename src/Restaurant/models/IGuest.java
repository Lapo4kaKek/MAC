package Restaurant.models;

import java.util.List;

public interface IGuest {
    String getVisName();

    void setVisName(String vis_name);

    String getVisOrdStarted();

    void setVisOrdStarted(String vis_ord_started);

    String getVisOrdEnded();

    void setVisOrdEnded(String vis_ord_ended);

    Integer getVisOrdTotal();

    void setVisOrdTotal(Integer vis_ord_total);

    public List<VisOrdDish> getVisOrdDishes();

    void setVisOrdDishes(List<VisOrdDish> vis_ord_dishes);
}
