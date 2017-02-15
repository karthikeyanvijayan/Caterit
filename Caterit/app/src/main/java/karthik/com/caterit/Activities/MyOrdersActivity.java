package karthik.com.caterit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import karthik.com.caterit.Adapters.MenuOrdersAdapter;
import karthik.com.caterit.Models.Menus;
import karthik.com.caterit.R;
import karthik.com.caterit.RestaurantManager;

public class MyOrdersActivity extends AppCompatActivity {

    ArrayList<Menus> orderedItemsList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarOrder);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        orderedItemsList = new ArrayList<>();
        orderedItemsList = RestaurantManager.Instance().getAllOrders(this);

        for (Menus menu: orderedItemsList) {
            Log.d("menus",menu.toOrders());
        }

        RecyclerView mOrderList = (RecyclerView) findViewById(R.id.ordersRecycleview);

        MenuOrdersAdapter adapter = new MenuOrdersAdapter(orderedItemsList,this);
        mOrderList.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mOrderList.setLayoutManager(layoutManager);
        mOrderList.setItemAnimator(new DefaultItemAnimator());

        Button btnorders = (Button) findViewById(R.id.btnPlaceOrder);
        btnorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentDetails = new Intent(MyOrdersActivity.this, CheckoutActivity.class);
                startActivity(paymentDetails);
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
