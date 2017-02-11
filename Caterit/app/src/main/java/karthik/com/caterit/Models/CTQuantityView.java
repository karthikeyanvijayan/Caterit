package karthik.com.caterit.Models;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import karthik.com.caterit.R;

/**
 * Created by user on 07/02/2017.
 */

interface QuantityInterface {

    public Integer quantityUpdated();

}

public class CTQuantityView extends LinearLayout implements QuantityInterface {

    Button buttonPlus, buttonMinus;
    TextView tvQuantity;
    Integer quantity = 0;

    public CTQuantityView(Context context) {
        super(context);
        this.initializeViews(context);
    }

    public CTQuantityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public CTQuantityView(Context context,
                       AttributeSet attrs,
                       int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }


    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.row_quantity, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

//        buttonMinus = (Button) findViewById(R.id.btnQuantityMinus);
//        buttonPlus = (Button) findViewById(R.id.btnQuantityAdd);
//        tvQuantity = (TextView) findViewById(R.id.tvAddQuantity);
//
//        buttonPlus.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                quantity += 1;
//                tvQuantity.setText(String.valueOf(quantity));
//            }
//        });
//
//        buttonMinus.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (quantity > 0) {
//                    quantity -= 1;
//                    tvQuantity.setText(String.valueOf(quantity));
//                }
//            }
//        });

    }

    @Override
    public Integer quantityUpdated() {
        return quantity;
    }
}
