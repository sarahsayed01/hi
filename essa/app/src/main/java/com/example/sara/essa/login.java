package com.example.sara.essa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class login extends AppCompatActivity implements View.OnClickListener{
    Button bLogin;
    EditText etUsername,etPassword;
    TextView tvregisterLink;
    UserLocalstore userLocalstore;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);
        bLogin=(Button)findViewById(R.id.bLogin);
        tvregisterLink=(TextView)findViewById(R.id.tvregisterLink);
        bLogin.setOnClickListener(this);
        tvregisterLink.setOnClickListener(this);
        userLocalstore= new UserLocalstore(this);

    }
    @Override
    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.bLogin:
            User user= new User(null,null);
            userLocalstore.storeUserData(user);
            userLocalstore.setUserLoggedIn(true);

            break;
        case R.id.tvregisterLink:
            startActivity(new Intent(this,register.class));
            break;
    }
    }
}
