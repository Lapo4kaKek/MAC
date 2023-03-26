package Restaurant.models;


import java.sql.Time;
import java.util.List;

public class AdvancedProduct{
    private Integer prod_item_id;
    private Integer prod_item_type;
    private String prod_item_name;
    private String prod_item_company;
    private String prod_item_unit;
    private Double prod_item_quantity;
    private Double prod_item_cost;
    private String prod_item_delivered;
    private String prod_item_valid_until;
    public AdvancedProduct() {};
    public Integer getProdId() {
        return prod_item_id;
    }
    public Integer getProdType() {
        return prod_item_type;
    }
    public String getProdName() {
        return prod_item_name;
    }
    public String getProdCompany() {
        return prod_item_company;
    }
    public String getProdUnit() {
        return prod_item_unit;
    }
    public Double getProdQuantity() {
        return prod_item_quantity;
    }
    public Double getProdCost() {
        return prod_item_cost;
    }
    public String getProdDelivered() {
        return prod_item_delivered;
    }
    public String getProdValidUntil() {
        return prod_item_valid_until;
    }


}
