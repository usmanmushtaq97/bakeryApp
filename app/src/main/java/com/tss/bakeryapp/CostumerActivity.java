package com.tss.bakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CostumerActivity extends AppCompatActivity {
   Button btNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costumer);
        btNext = findViewById(R.id.bt_costumer_next);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CostumerActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}