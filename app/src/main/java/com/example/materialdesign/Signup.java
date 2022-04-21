package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    Button signUp, loginTextButton;
    TextView memberSignInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp = findViewById(R.id.signUpButton);
        loginTextButton = findViewById(R.id.signInTextButton);
        memberSignInText = findViewById(R.id.memberText);

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        });
        loginTextButton.setOnClickListener(v -> {
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        });
        memberSignInText.setOnClickListener(v -> {
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        });
    }
}