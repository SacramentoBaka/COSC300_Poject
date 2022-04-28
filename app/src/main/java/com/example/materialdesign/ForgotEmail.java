package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ForgotEmail extends AppCompatActivity {

    private Button resetPassword;
    private TextInputLayout forgotPasswordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_email);

        forgotPasswordEdit = findViewById(R.id.textInputLayoutForgotPassEmail);
        resetPassword = findViewById(R.id.resetPassButton);

        resetPassword.setOnClickListener(v -> {

            if(!forgotPassValidation()){
                Toast.makeText(this, "Input required", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(ForgotEmail.this, "reset email sent", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ForgotEmail.this, Login.class);
            startActivity(intent);
            finish();
        });
    }
    public boolean forgotPassValidation() {

        String linkEmail = forgotPasswordEdit.getEditText().getText().toString().trim();
        if (linkEmail.isEmpty()) {

            forgotPasswordEdit.setError("Email Required*");
            return false;
        } else {
            forgotPasswordEdit.setError(null);
            return true;
        }
    }
}