package karthik.com.caterit;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import karthik.com.caterit.Models.Location;
import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.Models.Restaurant;

/**
 * Created by user on 17/01/2017.
 */

public class RestaurantManager {

    private static RestaurantManager instance;
    Context context;
    ArrayList<Restaurant> restaurantsList;

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
        return  locations.get(0);
    }

    public ArrayList<Restaurant> getAllRestaurants(Context mcontext) {

        this.context = mcontext;
        String stringRestaurants = this.loadJSONFromAsset();
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
                    Double lat =locationObject.getDouble("lat");
                    Log.d("lat",Double.toString(lat));
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




    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.context.getAssets().open("restaurant.json");
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


}
