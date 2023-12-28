package com.example.mastercalclulator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class sevanth extends AppCompatActivity {

    ImageView back;
    TextInputEditText totalMarksEditText, yourMarksEditText;
    Button calculateButton;
    public TextView yourPercentageTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sevanth);

        totalMarksEditText = findViewById(R.id.mathMarks);
        yourMarksEditText = findViewById(R.id.yourmarks);
        calculateButton = findViewById(R.id.calculateButton);
        yourPercentageTextView = findViewById(R.id.ans1);

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
            double totalMarks = Double.parseDouble(totalMarksEditText.getText().toString());
            double yourMarks = Double.parseDouble(yourMarksEditText.getText().toString());

            totalMarks = totalMarks / 100;

            double percentage = yourMarks / totalMarks;

            yourPercentageTextView.setText(String.format(" %.2f%%", percentage));

        } catch (NumberFormatException e) {
            yourPercentageTextView.setText("Please enter valid numbers for total and your marks.");
        }
    }
}
