package karthik.com.caterit.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.R;
import karthik.com.caterit.RestaurantManager;


public class MenuDetailsFragment extends Fragment {


    public MenuDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_details, container, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvMenu_detail_name);
        TextView tvDesc = (TextView) view.findViewById(R.id.tvMenu_detail_desc);
        TextView tvPrice = (TextView) view.findViewById(R.id.tvMenu_detail_price);
        ImageView imageMenu = (ImageView) view.findViewById(R.id.image_menu_detail);

        Menus selectedMenu = (Menus) RestaurantManager.Instance().getCurrentSelectedMenu();
        if (selectedMenu != null) {
            tvTitle.setText(selectedMenu.getName().toString());
            tvDesc.setText(selectedMenu.getMenu_desc().toString());
            tvPrice.setText(selectedMenu.toPrice());
            Glide.with(getActivity())
                    .load(selectedMenu.getItemurl())
                    .into(imageMenu);
        }

        return  view;
    }


}
