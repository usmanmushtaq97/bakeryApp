package com.tss.bakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class PaymentActivity extends AppCompatActivity {
    Button buttonOrder;
    Spinner paymentType;
    RadioGroup radioGroupEventType;
    EditText editTextAdditionalInformation;
    EditText editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        init();
    }
    // bind with view or connection
    private void init(){
        buttonOrder = findViewById(R.id.orderplace);
        paymentType = findViewById(R.id.spinner_payment);
        radioGroupEventType = findViewById(R.id.radio_group_event);
        editTextAdditionalInformation = findViewById(R.id.addtitonalinformation);
        editTextMessage = findViewById(R.id.message_id);
    }
}