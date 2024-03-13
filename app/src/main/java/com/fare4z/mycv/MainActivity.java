package com.fare4z.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_email,et_nric;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_nric = findViewById(R.id.et_nric);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("et_name",et_name.getText().toString());
                bundle.putString("et_email",et_email.getText().toString());
                bundle.putString("et_nric",et_nric.getText().toString());

                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}