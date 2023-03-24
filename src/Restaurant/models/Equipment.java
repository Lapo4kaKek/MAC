package Restaurant.models;


public class Equipment {
    private String name_;
    private Boolean active_;
    private Integer type_;
    public Equipment(String name, Boolean active, Integer type) {
        name_ = name;
        active_ = active;
        type_ = type;
    }

    public String getName(){ 
        return name_;
    }
    public Boolean getActive(){
        return active_;
    }
    public Integer getType(){
        return type_;
    }
}
