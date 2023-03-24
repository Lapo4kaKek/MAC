package Restaurant.models;
public class Cooker {
    private Integer cookId_;
    private String name_;
    private Boolean active_;

    Cooker(Integer id, String name, Boolean active ) {
        cookId_ = id;
        name_ = name;
        active_ = active;
    }

    public int getId() {
        return cookId_;
    }

    public String getName() {
        return name_;
    }

    public Boolean isActive() {
        return active_;
    }

}