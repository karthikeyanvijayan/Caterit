package karthik.com.caterit.Models;

import java.io.Serializable;

/**
 * Created by user on 17/01/2017.
 */

public class Menus implements Serializable {

    String name, menu_desc, itemurl;
    Double price;
    Integer quantity = 0;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemurl() {
        return itemurl;
    }

    public void setItemurl(String itemurl) {
        this.itemurl = itemurl;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu_desc() {
        return menu_desc;
    }

    public void setMenu_desc(String menu_desc) {
        this.menu_desc = menu_desc;
    }

    public String toPrice() {
        return "$" + price + "";
    }

    public String toSubTotal() {
        Double subtotal = quantity * price;
        return String.valueOf(subtotal);
    }

    public String toOrders() {
        return  name + " " + quantity;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
