package karthik.com.caterit.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import karthik.com.caterit.R;

public class ForgotPasswordActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        final EditText textEmail = (EditText)findViewById(R.id.textForgotPw);
        final TextView tvForgotPassword = (TextView) findViewById(R.id.tvForgotDesc) ;
        final TextInputLayout tvLayout = (TextInputLayout) findViewById(R.id.forgot_text_input_layout);


        Intent intentDetails = getIntent();
        String emailString = intentDetails.getStringExtra("email");
        if (emailString != null) {
            textEmail.setText(emailString);
        }

        Button btnClose = (Button) findViewById(R.id.btnForgotClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                textEmail.setVisibility(View.GONE);
                tvLayout.setVisibility(View.GONE);
                tvForgotPassword.setText("We've sent you a email with instructions on how to reset your password");
                btnReset.setText("LOGIN");
                //finish();
            }
        });

    }
}
