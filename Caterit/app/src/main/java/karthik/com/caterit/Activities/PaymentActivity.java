package karthik.com.caterit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import karthik.com.caterit.R;
import karthik.com.caterit.RestaurantManager;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPayment);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvTotal = (TextView) findViewById(R.id.tvChkAmount);
        String amountVal = RestaurantManager.Instance().orderTotalAmount();
        tvTotal.setText(amountVal);

        Button btnpayment = (Button) findViewById(R.id.btnPaymentOrder);
        btnpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ordercomplete = new Intent(PaymentActivity.this,OrderCompleteActivity.class);
                startActivity(ordercomplete);
            }
        });

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
