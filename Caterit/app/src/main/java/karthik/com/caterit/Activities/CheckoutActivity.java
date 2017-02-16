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

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCartDetails);
        setSupportActionBar(toolbar);

        TextView tvTotal = (TextView) findViewById(R.id.tvPyAmount);
        String amountVal = RestaurantManager.Instance().orderTotalAmount();
        tvTotal.setText(amountVal);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnProceed = (Button) findViewById(R.id.btnProceedtopay);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentconfirmation = new Intent(CheckoutActivity.this, PaymentActivity.class);
                startActivity(paymentconfirmation);
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
