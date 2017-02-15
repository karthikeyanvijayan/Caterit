package karthik.com.caterit.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import karthik.com.caterit.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPayment);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        RecyclerView paymentRecyleview = (RecyclerView) findViewById(R.id.paymentRecycleView);
//
//        ArrayList<Menus> orderedItems = RestaurantManager.Instance().getAllOrders(this);
//        MenuOrdersAdapter adapter = new MenuOrdersAdapter(orderedItems, this);
//
//        paymentRecyleview.setAdapter(adapter);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        paymentRecyleview.setLayoutManager(layoutManager);
//        paymentRecyleview.setItemAnimator(new DefaultItemAnimator());


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
