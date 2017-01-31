package karthik.com.caterit.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import karthik.com.caterit.Fragments.MenuListFragment;

/**
 * Created by user on 31/01/2017.
 */

public class MenuCategoryPagerAdapter extends FragmentStatePagerAdapter {

    public MenuCategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MenuListFragment menuListFragment = new MenuListFragment();
        return menuListFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
