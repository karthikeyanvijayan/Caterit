package karthik.com.caterit.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 17/01/2017.
 */

public class Restaurant implements Serializable {

    String name, address, restaurantid, cuisinetype , coverurl;
    ArrayList<Menus> menus;
    Location location;

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRestaurantid() {
        return restaurantid;
    }

    public String getCuisinetype() {
        return cuisinetype;
    }

    public ArrayList<Menus> getMenus() {
        return menus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRestaurantid(String restaurantid) {
        this.restaurantid = restaurantid;
    }

    public void setCuisinetype(String cuisinetype) {
        this.cuisinetype = cuisinetype;
    }

    public void setMenus(ArrayList<Menus> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", restaurantid='" + restaurantid + '\'' +
                ", cuisinetype='" + cuisinetype + '\'' +
                ", coverurl='" + coverurl + '\'' +
                ", menus=" + menus +
                ", location=" + location +
                '}';
    }
}
