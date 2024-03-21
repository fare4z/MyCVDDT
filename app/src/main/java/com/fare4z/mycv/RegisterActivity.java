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

public class RegisterActivity extends AppCompatActivity {

    EditText et_name,et_email,et_nric, et_password;
    Button btn_register;
    TextView tvLogin;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_nric = findViewById(R.id.et_nric);
        et_password = findViewById(R.id.et_password);

        btn_register = findViewById(R.id.btn_login);
        tvLogin = findViewById(R.id.tv_login);
        sp = getSharedPreferences("prefUser", Context.MODE_PRIVATE);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",et_name.getText().toString());
                editor.putString("email",et_email.getText().toString());
                editor.putString("nric",et_nric.getText().toString());
                editor.putString("password",et_password.getText().toString());
                editor.apply();

                Bundle bundle = new Bundle();
                bundle.putString("et_name",et_name.getText().toString());
                bundle.putString("et_email",et_email.getText().toString());
                bundle.putString("et_nric",et_nric.getText().toString());

                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}