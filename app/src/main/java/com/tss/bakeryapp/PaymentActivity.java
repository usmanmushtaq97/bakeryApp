package com.tss.bakeryapp;

import static com.tss.bakeryapp.Constant.AdditionalInformation;
import static com.tss.bakeryapp.Constant.message;
import static com.tss.bakeryapp.Constant.orderType;
import static com.tss.bakeryapp.Constant.paymentMethod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button buttonOrder;
    Spinner paymentType;
    RadioButton radioButton;
    RadioGroup radioGroupEventType;
    EditText editTextAdditionalInformation;
    EditText editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        init();

        // Spinner click listener
        paymentType.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> mList = new ArrayList<String>();
        mList.add("Credit");
        mList.add("Cash On Delivery");
        mList.add("Check");
        mList.add("Purchase Order");
        mList.add("PayPal");
        mList.add("Bank");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        paymentType.setAdapter(dataAdapter);

         buttonOrder.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(iSNotEmpty()){
                 Intent intent = new Intent(PaymentActivity.this,OrderSummery.class);
                 startActivity(intent);}
             }
         });
    }
    // bind with view or connection
    private void init(){
        buttonOrder = findViewById(R.id.orderplace);
        paymentType = findViewById(R.id.spinner_payment);
        radioGroupEventType = findViewById(R.id.radio_group_event);
        editTextAdditionalInformation = findViewById(R.id.addtitonalinformation);
        editTextMessage = findViewById(R.id.message_id);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Constant.paymentMethod = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private boolean iSNotEmpty(){
        Constant.message =editTextMessage.getText().toString();
        Constant.AdditionalInformation = editTextAdditionalInformation.getText().toString();
        int selectedRadioButtonId = radioGroupEventType.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            radioButton = findViewById(selectedRadioButtonId);
           Constant.EventType = radioButton.getText().toString();
        }
        else {
            Toast.makeText(PaymentActivity.this, "select payment type", Toast.LENGTH_SHORT).show();
        }
       if(message.isEmpty()){
           Toast.makeText(this, "Enter Message", Toast.LENGTH_SHORT).show();
           return  false;
       }
        if(AdditionalInformation.isEmpty()){
            Toast.makeText(this, "Enter Answer Additional Details", Toast.LENGTH_SHORT).show();
            return  false;
        }
        if(Constant.paymentMethod.isEmpty()){
            Toast.makeText(this, "Select payment type", Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }
}