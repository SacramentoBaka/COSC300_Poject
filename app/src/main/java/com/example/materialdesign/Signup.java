package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    private Button signUp, loginTextButton;
    private TextInputLayout usernameEdit, emailEdit, passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameEdit = findViewById(R.id.textInputLayoutUsername);
        emailEdit = findViewById(R.id.textInputLayoutEmail);
        passwordEdit = findViewById(R.id.textInputLayoutPassword);
        signUp = findViewById(R.id.signUpButton);
        loginTextButton = findViewById(R.id.signInTextButton);

        signUp.setOnClickListener(v -> {

            if(!usernameValidation() | !emailValidation() | !passwordValidation()){
                Toast.makeText(this, "Input Required", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        });
        loginTextButton.setOnClickListener(v -> {
            Intent intent = new Intent(Signup.this, Login.class);
            startActivity(intent);
            finish();
        });
    }

    public boolean usernameValidation() {

        String username = usernameEdit.getEditText().getText().toString().trim();
        if (username.isEmpty()) {

            usernameEdit.setError("Username Required*");
            return false;
        } else {
            usernameEdit.setError(null);
            return true;
        }
    }

    public boolean emailValidation() {

        String email = emailEdit.getEditText().getText().toString().trim();

        if (email.isEmpty()) {

            emailEdit.setError("Email Required*");
            return false;
        } else {
            emailEdit.setError(null);
            return true;
        }
    }

    public boolean passwordValidation() {

        String password = passwordEdit.getEditText().getText().toString().trim();

        if (password.isEmpty()) {

            passwordEdit.setError("Password Required*");
            return false;
        } else {
            passwordEdit.setError(null);
            return true;
        }
    }
}