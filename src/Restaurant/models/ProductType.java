package Restaurant.models;

public class ProductType {
    private Integer prod_type_id;
    private String prod_type_name;
    private Boolean prod_is_food;
    public ProductType() {};
    public Integer getProdTypeId() {
        return prod_type_id;
    }
    public String getTypeName() {
        return prod_type_name;
    }
    public Boolean getProdIsFood() {
        return prod_is_food;
    }
}
