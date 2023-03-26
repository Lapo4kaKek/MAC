package models;


public class Equipment {
    private String equip_name;
    private Boolean equip_active;
    private Integer equip_type;
    public Equipment(String name, Boolean active, Integer type) {
        equip_name = name;
        equip_active = active;
        equip_type = type;
    }

    public String getName(){ 
        return equip_name;
    }
    public Boolean getActive(){
        return equip_active;
    }
    public Integer getType(){
        return equip_type;
    }
}
