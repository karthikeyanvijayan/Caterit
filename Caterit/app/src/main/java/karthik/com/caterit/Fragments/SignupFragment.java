package karthik.com.caterit.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import karthik.com.caterit.Models.Customer;
import karthik.com.caterit.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    EditText textName, textEmail, textMobile, textPassword;

    Button btnSignup;


    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = (View) inflater.inflate(R.layout.fragment_signup, container, false);

        final SharedPreferences mPrefs = this.getActivity().getPreferences(MODE_PRIVATE);

        textEmail = (EditText) view.findViewById(R.id.textSgEmail);
        textName = (EditText) view.findViewById(R.id.textSgName);
        textMobile = (EditText) view.findViewById(R.id.textSgMobile);
        textPassword = (EditText) view.findViewById(R.id.textSgPassword);

        btnSignup = (Button) view.findViewById(R.id.buttonSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Customer customer = new Customer();
                customer.setName(textName.getText().toString());
                customer.setPassword(textPassword.getText().toString());
                customer.setEmail(textEmail.getText().toString());
                customer.setMobile(textMobile.getText().toString());

                SharedPreferences.Editor mEditor = mPrefs.edit();

                Gson gson = new Gson();
                String customerJson = gson.toJson(customer);

                mEditor.putString(getString(R.string.pref_customer), customerJson);
                mEditor.commit();

                String customerInfoString = mPrefs.getString(getString(R.string.pref_customer), "");
                Customer savedCustomer = gson.fromJson(customerInfoString, Customer.class);
                Log.d("customer", savedCustomer.toString());

            }
        });

        return view;
    }

}
