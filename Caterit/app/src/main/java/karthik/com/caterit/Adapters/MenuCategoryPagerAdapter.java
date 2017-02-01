package karthik.com.caterit.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import karthik.com.caterit.Fragments.MenuListFragment;

/**
 * Created by user on 31/01/2017.
 */

public class MenuCategoryPagerAdapter extends FragmentStatePagerAdapter {

    public MenuListFragment mCurrentFragment;

    public MenuListFragment getmCurrentFragment() {
        return mCurrentFragment;
    }

    public void setmCurrentFragment(MenuListFragment mCurrentFragment) {
        this.mCurrentFragment = mCurrentFragment;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (mCurrentFragment != object) {
            mCurrentFragment = (MenuListFragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

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
