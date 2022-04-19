package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button login;
    TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.logInButton);
        createAccount = findViewById(R.id.createAccountText);


        login.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        });
        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
            finish();
        });
    }
}