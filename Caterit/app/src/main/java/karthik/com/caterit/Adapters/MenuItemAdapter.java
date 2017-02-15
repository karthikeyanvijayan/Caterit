package karthik.com.caterit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import karthik.com.caterit.Activities.MenuDetailActivity;
import karthik.com.caterit.Models.CTQuantityView;
import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.Models.Restaurant;
import karthik.com.caterit.R;
import karthik.com.caterit.RestaurantManager;

/**
 * Created by user on 01/02/2017.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Restaurant selectedRestaurant;
    ArrayList<Menus> menus;
    Context context;
    Boolean isGrid = true;
    Integer currentQuantity = 0;


    public Boolean getGrid() {
        return isGrid;
    }

    public void setGrid(Boolean grid) {
        isGrid = grid;
    }

    public MenuItemAdapter(Context mContext, Restaurant mRestaurant, boolean mType) {
        this.context = mContext;
        this.selectedRestaurant = mRestaurant;
        this.menus = mRestaurant.getMenus();
        this.isGrid = mType;
        Log.d("constructor", "called");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (isGrid) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_item_grid, parent, false);
            return new GridViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_item_list, parent, false);
            return new ListViewHolder(itemView);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Menus menu_item = this.menus.get(position);

        if (menu_item != null) {
            String price = "$" + Double.toString(menu_item.getPrice());
            if (isGrid == true) {
                ((GridViewHolder) holder).itemname.setText(menu_item.getName());
                ((GridViewHolder) holder).item_price.setText(price);
                CTQuantityView quantityView = ((GridViewHolder) holder).quantity;
                if (quantityView != null) {
                    TextView tvQuantity = (TextView) quantityView.findViewById(R.id.tvAddQuantity);
                    if (tvQuantity != null) {
                        tvQuantity.setText(menu_item.getQuantity().toString());
                    }
                }

                // Glide unsplash background image
                Glide.with(context)
                        .load(menu_item.getItemurl())
                        .into(((GridViewHolder) holder).imageMenu);
            } else {
                ((ListViewHolder) holder).itemname.setText(menu_item.getName());
                ((ListViewHolder) holder).item_price.setText(price);
                // Glide unsplash background image
                Glide.with(context)
                        .load(menu_item.getItemurl())
                        .into(((ListViewHolder) holder).imageMenu);
            }
        }

    }

    @Override
    public int getItemCount() {
        return this.menus.size();
    }

    /**
     * @param context
     * @param restaurant
     * @param isGridMode
     */
    public void updateAdapter(Context context, Restaurant restaurant, Boolean isGridMode) {
        this.context = context;
        this.selectedRestaurant = restaurant;
        this.menus = restaurant.getMenus();
        this.isGrid = isGridMode;
        notifyDataSetChanged();
    }


    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemname, item_price;
        public ImageView imageMenu;
        CTQuantityView quantity;

        public GridViewHolder(View view) {
            super(view);
            itemname = (TextView) view.findViewById(R.id.tvMenuName);
            imageMenu = (ImageView) view.findViewById(R.id.image_menubg);
            item_price = (TextView) view.findViewById(R.id.tvMenuPrice);
            quantity = (CTQuantityView) view.findViewById(R.id.quantityView);

            Button btnPlus = (Button) quantity.findViewById(R.id.btnQuantityAdd);
            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateQuantity(getAdapterPosition(), true);
                }
            });

            Button btnMinus = (Button) quantity.findViewById(R.id.btnQuantityMinus);
            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateQuantity(getAdapterPosition(), false);
                }
            });

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            getMenuItem(position);
        }
    }


    void updateQuantity(int pos, Boolean isAdd) {

        Log.d("pos", String.valueOf(pos));

        if (pos == RecyclerView.NO_POSITION) {
            return;
        }
        Menus menu = (Menus) menus.get(pos);
        if (menu != null) {
            Log.d("Menu", menu.getQuantity().toString());

            int currentQuantity = menu.getQuantity();


            if (currentQuantity == 0 && !isAdd) {
                return;
            }


            if (isAdd) {
                currentQuantity++;
            } else {
                if (currentQuantity > 0) {
                    currentQuantity--;
                }
            }
            menu.setQuantity(currentQuantity);


            Log.d("Menu", menu.getQuantity().toString());

            this.notifyItemChanged(pos);
        }

    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemname, item_price;
        public ImageView imageMenu;
        CTQuantityView quantity;

        public ListViewHolder(View view) {
            super(view);
            itemname = (TextView) view.findViewById(R.id.tvMenulvName);
            imageMenu = (ImageView) view.findViewById(R.id.image_lvmenu);
            item_price = (TextView) view.findViewById(R.id.tvMenulvPrice);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            getMenuItem(position);
        }
    }

    void getMenuItem(int position) {
        if (position != RecyclerView.NO_POSITION) {
            Menus menu_item = menus.get(position);
            Intent detail = new Intent(context, MenuDetailActivity.class);
            String menuJson = (new Gson()).toJson(menu_item);
            detail.putExtra("menu", menuJson);
            RestaurantManager.Instance().setCurrentSelectedMenu(menu_item);
            context.startActivity(detail);
        }
    }

}
