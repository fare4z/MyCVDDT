package com.fare4z.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName,tvEmail,tvNRIC,tvAge;
    Button btn_portfolio, btnLogout;

    SharedPreferences spUser, sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvNRIC = findViewById(R.id.tvNRIC);
        tvAge = findViewById(R.id.tvAge);
        btn_portfolio = findViewById(R.id.btn_portfolio);
        spUser = getSharedPreferences("prefUser", Context.MODE_PRIVATE);
        sp = getSharedPreferences("prefLogin", Context.MODE_PRIVATE);

        btnLogout = findViewById(R.id.btnLogout);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            tvName.setText(bundle.getString("et_name").toUpperCase());
            tvEmail.setText(bundle.getString("et_email"));
            tvNRIC.setText(bundle.getString("et_nric"));

            tvAge.setText("20");
        } else {
            tvName.setText(spUser.getString("name","-"));
            tvEmail.setText(spUser.getString("email","-"));
            tvNRIC.setText(spUser.getString("nric","-"));
        }

        btn_portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PortfolioActivity.class);
                startActivity(i);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.apply();

                Toast.makeText(ProfileActivity.this, "Logout!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }
        });
    }




}