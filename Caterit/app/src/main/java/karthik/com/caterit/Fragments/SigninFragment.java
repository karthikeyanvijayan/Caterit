package karthik.com.caterit.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import karthik.com.caterit.R;

public class SigninFragment extends Fragment {

    EditText textEmail,textPassword;

    Button btnSignin;


    public SigninFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        textEmail = (EditText) view.findViewById(R.id.textLoginUsername);
        textPassword = (EditText) view.findViewById(R.id.textLoginPassword);

        btnSignin = (Button) view.findViewById(R.id.buttonSignin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return  view;
    }
}
