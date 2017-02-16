package karthik.com.caterit;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import karthik.com.caterit.Models.Location;
import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.Models.Restaurant;
import karthik.com.caterit.Models.Reviews;

/**
 * Created by user on 17/01/2017.
 */

public class RestaurantManager {

    private static RestaurantManager instance;
    Context context;
    ArrayList<Restaurant> restaurantsList;
    public ArrayList<Menus> orderList = new ArrayList<>();

    Menus currentSelectedMenu = null;


    public Menus getCurrentSelectedMenu() {
        return currentSelectedMenu;
    }

    public void setCurrentSelectedMenu(Menus currentSelectedMenu) {
        this.currentSelectedMenu = currentSelectedMenu;
    }

    public static RestaurantManager Instance() {
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public Restaurant getRestaurant(Context mcontext) {
        ArrayList<Restaurant> locations = getAllRestaurants(mcontext);
        return locations.get(0);
    }

    public ArrayList<Menus> getAllOrders(Context mContext) {
        Restaurant currentRestaurant = getRestaurant(mContext);
        if (currentRestaurant != null) {
            ArrayList<Menus> menuList = currentRestaurant.getMenus();
            for (Menus menuitem : menuList) {
                Random rand = new Random();
                int randomno = rand.nextInt(15) + 1;
                menuitem.setQuantity(randomno);
            }
            return menuList;
        }
        return null;
    }

    public ArrayList<Reviews> getAllReviews(Context mcontext) {
        String stringReviews = this.loadJSONFromAsset("reviews.json");
        //  try {
        Gson gson = new Gson();
        List<Reviews> reviews = Arrays.asList(gson.fromJson(stringReviews, Reviews[].class));
        ArrayList<Reviews> reviewsList = new ArrayList<>();
        for (Reviews reviewitem : reviews) {
            Log.d("review", reviewitem.toString());
            reviewsList.add(reviewitem);
        }
        return reviewsList;

    }

    public ArrayList<Restaurant> getAllRestaurants(Context mcontext) {

        this.context = mcontext;
        String stringRestaurants = this.loadJSONFromAsset("restaurant.json");
        restaurantsList = new ArrayList<>();

        try {

            JSONArray array = new JSONArray(stringRestaurants);
            for (int i = 0; i < array.length(); i++) {
                JSONObject restaurantJson = array.getJSONObject(i);
                Log.d("name", restaurantJson.getString("name"));
                Restaurant restaurant = new Restaurant();
                restaurant.setName(restaurantJson.getString("name"));
                restaurant.setCuisinetype(restaurantJson.getString("cuisines"));
                restaurant.setAddress(restaurantJson.getString("address"));
                restaurant.setRestaurantid(restaurantJson.getString("id"));
                restaurant.setCoverurl(restaurantJson.getString("coverurl"));

                JSONObject locationObject = restaurantJson.getJSONObject("location");
                if (locationObject != null) {
                    Location location = new Location();
                    Double lat = locationObject.getDouble("lat");
                    Log.d("lat", Double.toString(lat));
                    location.setLatitude(locationObject.getDouble("lat"));
                    location.setLongitude(locationObject.getDouble("longt"));
                    restaurant.setLocation(location);
                }

                JSONArray menusJson = restaurantJson.getJSONArray("menus");
                if (menusJson != null) {
                    ArrayList<Menus> menuList = new ArrayList<>();
                    for (int j = 0; j < menusJson.length(); j++) {
                        JSONObject menuitemJson = menusJson.getJSONObject(j);
                        Menus item = new Menus();
                        item.setName(menuitemJson.getString("name"));
                        item.setMenu_desc(menuitemJson.getString("desc"));
                        item.setPrice(menuitemJson.getDouble("price"));
                        item.setItemurl(menuitemJson.getString("itemurl"));
                        menuList.add(item);
                    }
                    restaurant.setMenus(menuList);
                }
                restaurantsList.add(restaurant);
            }

            for (Restaurant restaurant : restaurantsList) {
                Log.d("list", restaurant.toString());
            }

            return this.restaurantsList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = this.context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public void AddMenu(Menus menu) {
        if (orderList == null) {
            orderList = new ArrayList<Menus>();
        }

        int index = this.orderList.indexOf(menu);
        if (index != -1 && index < orderList.size()) {
            Menus menuItem = (Menus) orderList.get(index);
            menuItem.setQuantity(menu.getQuantity());
        } else {
            orderList.add(menu);
        }
    }

    public void removeMenu(Menus menu) {
        int index = this.orderList.indexOf(menu);
        Log.d("index", String.valueOf(index));
        if (index != -1 && index < orderList.size()) {
            this.orderList.remove(index);
        }
    }

    public String orderTotalAmount() {
        double amount = 0.0;
        amount = RestaurantManager.Instance().totalPrice();
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        String amountVal = "$" + df.format(amount);
        return amountVal;
    }

    public double totalPrice() {
        double total = 0.0;
        if (!this.orderList.isEmpty()) {
            for (Menus menu : orderList) {
                double amount = menu.getPrice() * menu.getQuantity();
                total += amount;
            }
        }
        return total;
    }


}
