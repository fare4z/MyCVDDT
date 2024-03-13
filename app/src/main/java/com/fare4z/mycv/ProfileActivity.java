package com.fare4z.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName,tvEmail,tvNRIC,tvAge;
    Button btn_portfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvNRIC = findViewById(R.id.tvNRIC);
        tvAge = findViewById(R.id.tvAge);
        btn_portfolio = findViewById(R.id.btn_portfolio);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            tvName.setText(bundle.getString("et_name").toUpperCase());
            tvEmail.setText(bundle.getString("et_email"));
            tvNRIC.setText(bundle.getString("et_nric"));

            tvAge.setText("20");

        }

        btn_portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PortfolioActivity.class);
                startActivity(i);
            }
        });
    }




}