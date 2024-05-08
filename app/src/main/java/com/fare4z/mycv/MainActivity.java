package com.fare4z.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_email,et_nric;
    Button btn_register;
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine,btnZero,btnPlus, btnEqual;
    TextView tvOutputAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_nric = findViewById(R.id.et_nric);
        btn_register = findViewById(R.id.btn_register);

        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnZero = findViewById(R.id.btn_zero);
        btnPlus = findViewById(R.id.btn_plus);
        btnEqual = findViewById(R.id.btn_equal);
        tvOutputAge = findViewById(R.id.tvOutputAge);

        btnOne.setOnClickListener(view -> addNumber(1));
        btnTwo.setOnClickListener(view -> addNumber(2));
        btnThree.setOnClickListener(view -> addNumber(3));
        btnFour.setOnClickListener(view -> addNumber(4));
        btnFive.setOnClickListener(view -> addNumber(5));
        btnSix.setOnClickListener(view -> addNumber(6));
        btnSeven.setOnClickListener(view -> addNumber(7));
        btnEight.setOnClickListener(view -> addNumber(8));
        btnNine.setOnClickListener(view -> addNumber(9));
        btnZero.setOnClickListener(view -> addNumber(0));
        btnPlus.setOnClickListener(view -> operasiTambah());


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

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = kira(tvOutputAge.getText().toString());
                tvOutputAge.setText(String.valueOf(age));
            }
        });

    }

    private void addNumber(int number) {
        String currentText = tvOutputAge.getText().toString();
        tvOutputAge.setText(currentText + number);
    }

    private void operasiTambah() {
        String currentText = tvOutputAge.getText().toString();
        tvOutputAge.setText(currentText + "+");
    }

    public int kira(String expression) {
        String[] parts = expression.split("\\+");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

}