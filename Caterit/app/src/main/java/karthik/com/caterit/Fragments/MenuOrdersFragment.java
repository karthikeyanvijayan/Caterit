package karthik.com.caterit.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import karthik.com.caterit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuOrdersFragment extends Fragment {

    public MenuOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_orders, container, false);
    }

}
