package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button login, signUp, forgotPassword;
    TextView createAccount;
    private TextInputLayout logInUsernameEdit, logInPasswordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.logInButton);
        createAccount = findViewById(R.id.signUpNow);
        signUp = findViewById(R.id.signUpTextButton);
        logInUsernameEdit = findViewById(R.id.textInputLayoutLoginUsername);
        logInPasswordEdit = findViewById(R.id.textInputLayoutLoginPassword);


        login.setOnClickListener(v -> {

            if(!logInUsernameValidation() | !logInPasswordValidation()){
                return;
            }
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        });
        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
            finish();
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public boolean logInUsernameValidation() {

        String username = logInUsernameEdit.getEditText().getText().toString().trim();
        if (username.isEmpty()) {

            logInUsernameEdit.setError("Username Required*");
            return false;
        } else {
            logInUsernameEdit.setError(null);
            return true;
        }
    }
    public boolean logInPasswordValidation() {

        String password = logInPasswordEdit.getEditText().getText().toString().trim();

        if (password.isEmpty()) {

            logInPasswordEdit.setError("Password Required*");
            return false;
        } else {
            logInPasswordEdit.setError(null);
            return true;
        }
    }
}