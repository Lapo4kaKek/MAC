package models;
public class Cooker {
    private Integer cook_id;
    private String cook_name;
    private Boolean cook_active;

    Cooker(Integer id, String name, Boolean active ) {
        cook_id = id;
        cook_name = name;
        cook_active = active;
    }
    public int getId() {
        return cook_id;
    }
    public String getName() {
        return cook_name;
    }
    public Boolean isActive() {
        return cook_active;
    }
    public void changeActive() {
        if (cook_active) {
            cook_active = false;
        } else {
            cook_active = true;
        }
    }
}