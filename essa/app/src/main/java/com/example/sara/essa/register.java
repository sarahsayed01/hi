package com.example.sara.essa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity implements View.OnClickListener {

    Button bregister;
    EditText etName,etAge,etUsername,etPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName=(EditText)findViewById(R.id.etName);
        etAge=(EditText)findViewById(R.id.etAge);
        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bregister=(Button)findViewById(R.id.bregister);
        bregister.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bregister:

                String name=etName.getText().toString();
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                int age= Integer.parseInt(etAge.getText().toString());

                User registeredData=new User(name ,age,username,password) ;
                break;
        }
    }
}
