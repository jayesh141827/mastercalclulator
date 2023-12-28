package com.example.mastercalclulator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;



public class Sixth extends AppCompatActivity {
    ImageView back;

    TextInputEditText loanAmountEditText , interestRateEditText , loanTenureEditText ;
    TextView interestAmountTextView, totalInterestTextView, totalPayableAmountTextView;
    Button calculateButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        back = findViewById(R.id.back);

        loanAmountEditText  = findViewById(R.id.loanAmountEditText);
        interestRateEditText  = findViewById(R.id.interestRateEditText);
        loanTenureEditText = findViewById(R.id.loanTenureEditText);
        interestAmountTextView = findViewById(R.id.interestAmountTextView);
        totalInterestTextView = findViewById(R.id.totalInterestTextView);
        totalPayableAmountTextView = findViewById(R.id.totalPayableAmountTextView);
        calculateButton = findViewById(R.id.calculateButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEMI();
            }
        });
    }


    public void calculateEMI() {
        try {
            double principal = Double.parseDouble(loanAmountEditText.getText().toString());
            double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
            double tenure = Double.parseDouble(loanTenureEditText.getText().toString());


            double monthlyInterestRate = (interestRate / 12) / 100;
            int numberOfPayments = (int) (tenure * 12);


            double emi = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);


            double interestAmount = emi * numberOfPayments - principal;


            double totalInterest = emi * numberOfPayments - principal;


            double totalAmount = emi * numberOfPayments;


            interestAmountTextView.setText(String.format("%.2f", interestAmount));
            totalInterestTextView.setText(String.format(" %.2f", totalInterest));
            totalPayableAmountTextView.setText(String.format("%.2f", totalAmount));

        } catch (NumberFormatException e) {

            interestAmountTextView.setText("Please enter valid values");
            totalInterestTextView.setText("");
            totalPayableAmountTextView.setText("");
        }
    }
}