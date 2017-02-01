package karthik.com.caterit.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import karthik.com.caterit.Adapters.MenuCategoryPagerAdapter;
import karthik.com.caterit.Fragments.MenuListFragment;
import karthik.com.caterit.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    Boolean isGridMenu = true;
    ViewPager menuPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setTitle("Caterit");


        // getSupportActionBar().setIcon(R.drawable.ic_menu);
        // Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this,
                drawer,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);


        drawer.setDrawerListener(toggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabMenu);
        tabLayout.addTab(tabLayout.newTab().setText("MAIN DISHES"));
        tabLayout.addTab(tabLayout.newTab().setText("DESSERTS"));
        tabLayout.addTab(tabLayout.newTab().setText("DRINKS"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        // Pager
        menuPager = (ViewPager) findViewById(R.id.pagerHome);

        MenuCategoryPagerAdapter adapter = new MenuCategoryPagerAdapter(getSupportFragmentManager());

        menuPager.setAdapter(adapter);
        menuPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(menuPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                menuPager.setCurrentItem(tab.getPosition());
            }
        });
    }
//
//    @Override
//    public void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        toggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        toggle.onConfigurationChanged(newConfig);
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int menuId = item.getItemId();


//
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
//
//        //noinspection SimplifiableIfStatement
        if (menuId == R.id.action_menu) {

            isGridMenu = !isGridMenu;
            if (!isGridMenu) {
                item.setIcon(R.drawable.ic_dns);
            } else {
                item.setIcon(R.drawable.ic_dashboard);
            }

            MenuDisplayModeChanged();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.action_menu) {
            Log.d("menu choice", "toggle");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void MenuDisplayModeChanged() {
        int mCurrentPagerPos = menuPager.getCurrentItem();

        for (int index = 0; index < 3; index++) {
            FragmentStatePagerAdapter a = (FragmentStatePagerAdapter) menuPager.getAdapter();
            MenuListFragment menuListFragment = (MenuListFragment) a.instantiateItem(menuPager, index);
            if (menuListFragment != null) {
                Log.d("menu", "list framgmenter");
                if (menuListFragment.getView() != null) {
                    menuListFragment.reloadMenuListForDisplayMode(isGridMenu);
                }
            }
        }


    }

}
