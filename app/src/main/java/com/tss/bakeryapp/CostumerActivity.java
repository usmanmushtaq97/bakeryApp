package com.tss.bakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CostumerActivity extends AppCompatActivity {
   Button btNext;
   EditText editTextName, editTextEmail, editTextMobile, editTextDeliveryAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costumer);
        init();
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()) {
                    Intent intent = new Intent(CostumerActivity.this, PaymentActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    // connection with front end
    private  void init(){
        editTextName = findViewById(R.id.costumer_name);
        editTextEmail = findViewById(R.id.email_costumer);
        editTextMobile = findViewById(R.id.costumer_phone);
        editTextDeliveryAddress = findViewById(R.id.addresseidit);
        btNext = findViewById(R.id.bt_costumer_next);
    }
    private void getIntentValue(){

    }
    // validation of form
    private  boolean checkValidation(){
        Constant.NAME= editTextName.getText().toString();
        Constant.EMAIL = editTextEmail.getText().toString();
       Constant.PHONE = editTextMobile.getText().toString();
       Constant.ADDRESS = editTextDeliveryAddress.getText().toString();

       if(Constant.NAME.isEmpty()){
           Toast.makeText(this, "Enter the Name", Toast.LENGTH_SHORT).show();
           return false;
       }
       else if(Constant.EMAIL.isEmpty()){
            Toast.makeText(this, "Enter the Email", Toast.LENGTH_SHORT).show();
            return false;
        }
       else if(Constant.PHONE.isEmpty()){
            Toast.makeText(this, "Enter the Phone", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(Constant.ADDRESS.isEmpty()){
            Toast.makeText(this, "Enter the Address", Toast.LENGTH_SHORT).show();
            return false;
        }
       return true;

    }
}