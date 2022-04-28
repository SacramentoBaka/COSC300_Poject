package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    private Button login, signUp;
    private TextView forgotPassword;
    private TextView createAccount;
    private TextInputLayout logInUsernameEdit, logInPasswordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.logInButton);
        createAccount = findViewById(R.id.signUpNow);
        forgotPassword = findViewById(R.id.forgotPassText);
        signUp = findViewById(R.id.signUpTextButton);
        logInUsernameEdit = findViewById(R.id.textInputLayoutLoginUsername);
        logInPasswordEdit = findViewById(R.id.textInputLayoutLoginPassword);


        login.setOnClickListener(v -> {

            if(!logInUsernameValidation() | !logInPasswordValidation()){
                Toast.makeText(this, "All inputs required", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        });
        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
            finish();
        });
        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
            finish();
        });
        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, ForgotEmail.class);
            startActivity(intent);
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