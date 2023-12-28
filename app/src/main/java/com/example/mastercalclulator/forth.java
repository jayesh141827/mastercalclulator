package com.example.mastercalclulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class forth extends AppCompatActivity {

    ImageView back;

    EditText etAmount, etInterest, etTime;
    Button btnCalculate;
    TextView tvInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        back = findViewById(R.id.back);

        etAmount = findViewById(R.id.Amount);
        etInterest = findViewById(R.id.Interest);
        etTime = findViewById(R.id.Time);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvInterest = findViewById(R.id.Interesta);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateInterest();
            }
        });
    }

    private void calculateInterest() {
        try {
            double amount = Double.parseDouble(etAmount.getText().toString());
            double interestRate = Double.parseDouble(etInterest.getText().toString());
            double time = Double.parseDouble(etTime.getText().toString());

            double interestAmount = (amount * interestRate * time) / 100;

            tvInterest.setText(String.format("%.2f", interestAmount));
        } catch (NumberFormatException e) {
            // Handle the case where the user enters non-numeric values
            tvInterest.setText("Invalid input");
        }
    }
}
