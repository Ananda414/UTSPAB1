package com.if3a.utspab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private EditText etName, etCity, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etName = findViewById(R.id.et_name);
        etCity = findViewById(R.id.et_city);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        Button btnSignRegister = findViewById(R.id.btn_sign_register);

        btnSignRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, city, email, password;

                name = etName.getText().toString();
                city = etCity.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                Intent intent = new Intent(Register.this, Result.class);
                intent.putExtra("varName", name);
                intent.putExtra("varCity", city);
                intent.putExtra("varEmail", email);
                intent.putExtra("varPassword", password);
                startActivity(intent);
            }
        });
    }
}