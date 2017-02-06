package karthik.com.caterit.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import karthik.com.caterit.Adapters.MenuReviewAdapter;
import karthik.com.caterit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuReviewsFragment extends Fragment {


    public MenuReviewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_reviews, container, false);

        MenuReviewAdapter adapter = new MenuReviewAdapter(getActivity());

        RecyclerView mReviewsRecycleView = (RecyclerView) view.findViewById(R.id.reviewsRecycleView);
        mReviewsRecycleView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mReviewsRecycleView.setLayoutManager(layoutManager);
        mReviewsRecycleView.setItemAnimator(new DefaultItemAnimator());


        return view;
    }

}
