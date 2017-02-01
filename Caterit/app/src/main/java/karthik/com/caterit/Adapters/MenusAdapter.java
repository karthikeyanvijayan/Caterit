package karthik.com.caterit.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.Models.Restaurant;
import karthik.com.caterit.R;


/**
 * Created by user on 24/01/2017.
 */

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MyViewHolder> {

    Restaurant selectedRestaurant;
    ArrayList<Menus> menus;
    Context context;


    public MenusAdapter(Context mContext, Restaurant mRestaurant) {
        this.context = mContext;
        this.selectedRestaurant = mRestaurant;
        this.menus = mRestaurant.getMenus();
        Log.d("constructor", "called");
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_grid, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Menus menu_item = this.menus.get(position);
        if (menu_item != null) {
            holder.itemname.setText(menu_item.getName());
//            holder.menudesc.setText(menu_item.getMenu_desc());
            String price = "$" + Double.toString(menu_item.getPrice());
            holder.item_price.setText(price);

            // Glide unsplash background image
            Glide.with(context)
                    .load(menu_item.getItemurl())
                    .into(holder.imageMenu);
        }
    }

    @Override
    public int getItemCount() {
        return this.menus.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemname, menudesc,item_price;
        public ImageView imageMenu;

        public MyViewHolder(View view) {
            super(view);
            itemname = (TextView) view.findViewById(R.id.tvMenuName);
            imageMenu = (ImageView) view.findViewById(R.id.image_menubg);
            item_price = (TextView)view.findViewById(R.id.tvMenuPrice);
        }
    }
}
