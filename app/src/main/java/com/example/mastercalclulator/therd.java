package com.example.mastercalclulator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class therd extends AppCompatActivity {

    ImageView back;


    EditText etPrincipal, etRate, etTime;
    Button btnCalculate;
    TextView tvInvested, tvReturns, tvTotalValue, tvClearAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therd);

        back = findViewById(R.id.back);


        etPrincipal = findViewById(R.id.etPrincipal);
        etRate = findViewById(R.id.etRate);
        etTime = findViewById(R.id.etTime);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvClearAll = findViewById(R.id.tvClearAll);
        tvInvested = findViewById(R.id.tvInvested);
        tvReturns = findViewById(R.id.tvReturns);
        tvTotalValue = findViewById(R.id.tvTotalValue);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMutualFund();
            }
        });

        tvClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllFields();
            }
        });
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    void calculateMutualFund() {
        try {
            double principal = Double.parseDouble(etPrincipal.getText().toString());
            double rate = Double.parseDouble(etRate.getText().toString());
            double time = Double.parseDouble(etTime.getText().toString());


            double returns = principal * Math.pow((1 + rate / 100), time) - principal;
            double totalValue = principal + returns;


            tvInvested.setText(String.format("%.2f", principal));
            tvReturns.setText(String.format("%.2f", returns));
            tvTotalValue.setText(String.format("%.2f", totalValue));

        } catch (NumberFormatException e) {
            tvInvested.setText("Please enter valid numbers");
            tvReturns.setText("");
            tvTotalValue.setText("");
        }
    }

    void clearAllFields() {
        etPrincipal.setText("");
        etRate.setText("");
        etTime.setText("");
        tvInvested.setText("");
        tvReturns.setText("");
        tvTotalValue.setText("");
    }
}
