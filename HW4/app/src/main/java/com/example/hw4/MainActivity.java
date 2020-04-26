package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    Button register ;
    Button login;
    TextView feedback;
    EditText account;
    EditText password;
    LoginViewModel loginViewModel = LoginViewModel.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        account = findViewById(R.id.editAccount);
        password = findViewById(R.id.editPassword);
        feedback = findViewById(R.id.feedback);
        setOnClickListener();

        //  pass the login
        account.setText("root@gmail.com");
        password.setText("Zzxcv123456");
        login.callOnClick();
    }
    public void setOnClickListener() {
     register.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent it = new Intent();
             it.setClass(MainActivity.this, RegisterActivity.class);
             startActivity(it);
         }
     });
     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             User user = new User(account.getText().toString(), password.getText().toString());
             if(loginViewModel.isUser(user)){
                 Intent it = new Intent();
                 it.setClass(MainActivity.this, DashboardActivity.class);
                 startActivity(it);
                 finish();
             } else{
                 Log.v("Error", "Is Not User");
                 loginViewModel.showUser();
                 feedback.setVisibility(View.VISIBLE);
             }
         }
    });
    }
}
