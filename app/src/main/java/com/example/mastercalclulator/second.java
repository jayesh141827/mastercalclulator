package com.example.mastercalclulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class second extends AppCompatActivity {


    CardView Interest, Fund, Discount, Emi, School, Square;
    ImageView back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Interest = (CardView) findViewById(R.id.Interest);

        back = (ImageView) findViewById(R.id.back);

        Fund = (CardView) findViewById(R.id.Fund);

        Discount = (CardView) findViewById(R.id.Discount);

        Emi = (CardView) findViewById(R.id.Emi);

        School = (CardView) findViewById(R.id.School);

        Square = (CardView) findViewById(R.id.Square);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(second.this, therd.class);
                startActivity(intent);
            }
        });

        Interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(second.this, forth.class);
                startActivity(intent);
            }
        });
        Discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(second.this, Discount.class);
                startActivity(intent);
            }
        });


        Emi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(second.this, Sixth.class);
                startActivity(intent);
            }
        });

        School.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(second.this, sevanth.class);
                startActivity(intent);
            }
        });
        Square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(second.this, schoolresult.class);
                startActivity(intent);
            }
        });



    }
}