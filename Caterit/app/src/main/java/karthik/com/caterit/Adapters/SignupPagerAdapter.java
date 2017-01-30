package karthik.com.caterit.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import karthik.com.caterit.Fragments.SigninFragment;
import karthik.com.caterit.Fragments.SignupFragment;

/**
 * Created by user on 30/01/2017.
 */

public class SignupPagerAdapter extends FragmentStatePagerAdapter {

    public SignupPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SignupFragment signupFragment = new SignupFragment();
                return signupFragment;
            case 1:
                SigninFragment signinFragment = new SigninFragment();
                return signinFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
