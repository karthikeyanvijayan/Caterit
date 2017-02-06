package karthik.com.caterit.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import karthik.com.caterit.Fragments.MenuDetailsFragment;
import karthik.com.caterit.Fragments.MenuReviewsFragment;

/**
 * Created by user on 30/01/2017.
 */

public class MenuDetailPagerAdapter extends FragmentStatePagerAdapter {

    public MenuDetailPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MenuDetailsFragment menuDetailsFragment = new MenuDetailsFragment();
                return menuDetailsFragment;
            case 1:
                MenuReviewsFragment menuReviewsFragment = new MenuReviewsFragment();
                return menuReviewsFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
