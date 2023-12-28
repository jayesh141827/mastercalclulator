package com.example.mastercalclulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class schoolresult extends AppCompatActivity {

    ImageView back;
    TextInputEditText inputMarksEditText, squareOrHourEditText;
    Button calculateButton;
    TextView resultTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolresult);
        inputMarksEditText = findViewById(R.id.inputMarksEditText);
        squareOrHourEditText = findViewById(R.id.squareOrHour);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.result);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    void calculateResult() {
        try {
            double totalMarks = Double.parseDouble(inputMarksEditText.getText().toString());
            double yourMarkssquareOrHour = Double.parseDouble(squareOrHourEditText.getText().toString());

            double result = (yourMarkssquareOrHour / totalMarks) * 100;

            resultTextView.setText(String.format("%.2f%%", result));

        } catch (NumberFormatException e) {
            resultTextView.setText("Please enter valid numbers for total and your marks.");
        }
    }
}


