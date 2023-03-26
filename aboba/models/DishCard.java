package models;


import java.util.List;

public class DishCard {
    private int card_id;
    private String dish_name;
    private String card_descr;
    private double card_time;
    private int equip_type;
    private List<Operation> operations;

    public int getCardId() {
        return card_id;
    }

    public void setCardId(int card_id) {
        this.card_id = card_id;
    }

    public String getDishName() {
        return dish_name;
    }

    public void setDishName(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getCardDescr() {
        return card_descr;
    }

    public void setCardDescr(String card_descr) {
        this.card_descr = card_descr;
    }

    public double getCardTime() {
        return card_time;
    }

    public void setCardTime(double card_time) {
        this.card_time = card_time;
    }

    public int getEquipType() {
        return equip_type;
    }

    public void setEquipType(int equip_type) {
        this.equip_type = equip_type;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}

