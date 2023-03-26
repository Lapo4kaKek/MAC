package models;

import java.util.List;

public class Operation {
    private int oper_type;
    private double oper_time;
    private int oper_async_point;
    private List<Product> oper_products;

    public int getOperType() {
        return oper_type;
    }

    public void setOperType(int oper_type) {
        this.oper_type = oper_type;
    }

    public double getOperTime() {
        return oper_time;
    }

    public void setOperTime(double oper_time) {
        this.oper_time = oper_time;
    }

    public int getOperAsyncPoint() {
        return oper_async_point;
    }

    public void setOperAsyncPoint(int oper_async_point) {
        this.oper_async_point = oper_async_point;
    }

    public List<Product> getOperProducts() {
        return oper_products;
    }

    public void setOperProducts(List<Product> oper_products) {
        this.oper_products = oper_products;
    }
}