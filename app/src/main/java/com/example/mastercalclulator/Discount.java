package com.example.mastercalclulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Discount extends AppCompatActivity {

    ImageView back;
    EditText AmountEditText, discountEditText;
    Button calculate;
    TextView PriceAfterDiscount, savedAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        back = findViewById(R.id.back);
        AmountEditText = findViewById(R.id.Amount);
        discountEditText = findViewById(R.id.discount);
        calculate = findViewById(R.id.calculate);
        PriceAfterDiscount = findViewById(R.id.PriceAfterDiscount);
        savedAmount = findViewById(R.id.savedAmount);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                double price = Double.parseDouble(AmountEditText.getText().toString());
                double discount = Double.parseDouble(discountEditText.getText().toString());
                double result;

                result = price - price * discount / 100;

                double save = price - result;

                PriceAfterDiscount.setText(String.format("%.2f", result));
                savedAmount.setText(String.format("%.2f",save));

            }
        });    }
}

