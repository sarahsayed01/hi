package com.example.sara.essa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText etName, etAge, etUsername;
    UserLocalstore userLocalstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        bLogout = (Button) findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);
        userLocalstore= new UserLocalstore(this);
    }
    @Override
    protected void onStart(){
        super.onStart();
        if (authentication()==true){
            displayUserDetails();
        }
    }
    private boolean authentication(){
        return userLocalstore.getUserLoggedIn();

    }
    private void displayUserDetails(){
        User user=userLocalstore.getLoggedInUser() ;
        etUsername.setText(user.username);
        etName.setText(user.name);
        etAge.setText(user.age+"");



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogout:
                userLocalstore.clearUserData();
                userLocalstore.setUserLoggedIn(false);
                startActivity(new Intent(this,login.class));
                break;
        }
    }
}