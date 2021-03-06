package karthik.com.caterit.Models;

import java.io.Serializable;

/**
 * Created by user on 17/01/2017.
 */

public class Menus implements Serializable  {

    String name, menu_desc, itemurl;
    Double price;

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

    @Override
    public String toString() {
        return "Menus{" +
                "name='" + name + '\'' +
                ", menu_desc='" + menu_desc + '\'' +
                ", itemurl='" + itemurl + '\'' +
                ", price=" + price +
                '}';
    }
}
