package karthik.com.caterit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import karthik.com.caterit.Adapters.MenuDetailPagerAdapter;
import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.R;

public class MenuDetailActivity extends AppCompatActivity {


    ViewPager pagerMenuDetail;
    TabLayout tabLayout;
    Menus selectedMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Intent getMenuIntent = getIntent();
        String jsonToMenu = getMenuIntent.getStringExtra("menu");
        if (jsonToMenu != null) {
            Menus menuTemp = (Menus) (new Gson()).fromJson(jsonToMenu, Menus.class);
            if (menuTemp != null) {
                selectedMenuItem = menuTemp;
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMenuDetail);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        if (selectedMenuItem != null) {
            tvTitle.setText(selectedMenuItem.getName());
        }

        pagerMenuDetail = (ViewPager) findViewById(R.id.pagerMenuDetail);
        tabLayout = (TabLayout) findViewById(R.id.tabMenuDetail);

        tabLayout.addTab(tabLayout.newTab().setText("DETAILS"));
        tabLayout.addTab(tabLayout.newTab().setText("REVIEWS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        MenuDetailPagerAdapter adapter = new MenuDetailPagerAdapter(getSupportFragmentManager());

        pagerMenuDetail.setAdapter(adapter);
        pagerMenuDetail.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pagerMenuDetail) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pagerMenuDetail.setCurrentItem(tab.getPosition());
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
