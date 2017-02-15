package karthik.com.caterit.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.R;

/**
 * Created by user on 10/02/2017.
 */


public class MenuOrdersAdapter extends RecyclerView.Adapter<MenuOrdersAdapter.OrderViewHolder> {

    ArrayList<Menus> orderList = null;
    Context context;

    public MenuOrdersAdapter(ArrayList<Menus> orderList, Context mContext) {
        this.orderList = orderList;
        context = mContext;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvItemName, tvItemPrice, tvItemQuantity;
        ImageView imageMenu;
        Button btnPlus, btnMinus;

        public OrderViewHolder(View view) {
            super(view);
            tvItemName = (TextView) view.findViewById(R.id.tvOrderMenuName);
            tvItemPrice = (TextView) view.findViewById(R.id.tvOrderPrice);
            tvItemQuantity = (TextView) view.findViewById(R.id.tvOrderQuantity);
            imageMenu = (ImageView) view.findViewById(R.id.image_order);
            btnPlus = (Button) view.findViewById(R.id.btnOrderPlus);
            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition(); // gets item position
                    updateQuantityForMenu(position,true);
                }
            });

            btnMinus = (Button) view.findViewById(R.id.btnOrderMinus);
            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition(); // gets item position
                    updateQuantityForMenu(position,false);
                }
            });

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
        }
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_orders, parent, false);
        return new MenuOrdersAdapter.OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {

        Menus menu = (Menus) orderList.get(position);
        if (menu != null) {
            Log.d("Menu", menu.toString());
            holder.tvItemName.setText(menu.getName());
            holder.tvItemPrice.setText(menu.toPrice());
            holder.tvItemQuantity.setText("x " + menu.getQuantity().toString());
            Glide.with(context)
                    .load(menu.getItemurl())
                    .into(((OrderViewHolder) holder).imageMenu);
        }

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


    void updateQuantityForMenu(int pos,Boolean isAdd) {

        Menus menu = (Menus) orderList.get(pos);
        if (menu != null) {
            int currentQuantity = menu.getQuantity();

            if (currentQuantity == 1 && !isAdd) {

                orderList.remove(pos);
                this.notifyItemRemoved(pos);

                return;
            }


            if (isAdd) {
                currentQuantity++;
            }
            else {
                if (currentQuantity > 0) {
                    currentQuantity--;
                }
            }
            menu.setQuantity(currentQuantity);


            Log.d("Menu",menu.getQuantity().toString());

            this.notifyItemChanged(pos);
        }
    }
}
