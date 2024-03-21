package com.fare4z.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    TextView tvRegister;
    EditText etUsername, etPassword;
    Button btnLogin;
    SharedPreferences sp, spUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvRegister = findViewById(R.id.tv_register);
        etUsername = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        sp = getSharedPreferences("prefLogin", Context.MODE_PRIVATE);
        spUser = getSharedPreferences("prefUser", Context.MODE_PRIVATE);

        String dummyUsername = spUser.getString("email","-");
        String dummyPassword = spUser.getString("password","-");

        Boolean isLoggedIn = sp.getBoolean("isLoggedin", false);
        if (isLoggedIn) {
            Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(i);
        }

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LoginActivity.this, dummyUsername.toString(), Toast.LENGTH_SHORT).show();

                if(dummyUsername.toString().equals(etUsername.getText().toString()) && dummyPassword.toString().equals(etPassword.getText().toString())) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("username",etUsername.getText().toString());
                    editor.putBoolean("isLoggedin", true);
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Log Masuk Berjaya", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}