package karthik.com.caterit.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import karthik.com.caterit.Adapters.MenuItemAdapter;
import karthik.com.caterit.Adapters.MenuListAdapter;
import karthik.com.caterit.Adapters.MenusAdapter;
import karthik.com.caterit.Models.Restaurant;
import karthik.com.caterit.R;
import karthik.com.caterit.RestaurantManager;


public class MenuListFragment extends Fragment {

    MenusAdapter gridAdapter = null;
    MenuListAdapter listAdapter = null;
    RecyclerView menuListRecycleView;
    Boolean isGridMode = false;
    Restaurant restaurant = null;
    MenuItemAdapter adapter;

    public MenuListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View) inflater.inflate(R.layout.fragment_menu_list, container, false);

        restaurant = RestaurantManager.Instance().getRestaurant(getActivity());
        gridAdapter = new MenusAdapter(getContext(), restaurant);
        listAdapter = new MenuListAdapter(getContext(), restaurant);
        adapter = new MenuItemAdapter(getContext(),restaurant,isGridMode);

        menuListRecycleView = (RecyclerView) view.findViewById(R.id.menuRecycleView);
        menuListRecycleView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        menuListRecycleView.setLayoutManager(layoutManager);
        menuListRecycleView.setItemAnimator(new DefaultItemAnimator());


        return view;
    }

    public void reloadMenuListForDisplayMode(boolean isGrid) {
        String type = (isGrid == true) ? "isgrid" : "list";
        Log.d("fragment",type);
        isGridMode = isGrid;
        adapter = new MenuItemAdapter(getContext(),restaurant,isGridMode);
        menuListRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        menuListRecycleView.setAdapter(adapter);
    }



}
