package com.tss.bakeryapp;

import static com.tss.bakeryapp.Constant.dateSelected;
import static com.tss.bakeryapp.Constant.orderType;
import static com.tss.bakeryapp.Constant.timeSelected;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.leanback.widget.picker.TimePicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btNext;
    EditText editTextDate;
    EditText editTextTime;
    int mHour, mMinute;
    RadioGroup radioGroupOderType;
    RadioButton radioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btNext = findViewById(R.id.bt_next_main);
        editTextDate = findViewById(R.id.date_id);
        editTextTime = findViewById(R.id.edit_time);
        radioGroupOderType = findViewById(R.id.radio_group_ordertype);
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
                editTextDate.setText(Constant.selectedDate);
            }
        });


        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        (TimePickerDialog.OnTimeSetListener) (view, hourOfDay, minute) -> editTextTime.setText(hourOfDay + ":" + minute), mHour, mMinute, false);
                timePickerDialog.show();
            }

        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    Intent intent = new Intent(MainActivity.this, CostumerActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    // check the Validation of form
    private boolean validation() {
        dateSelected = editTextDate.getText().toString();
       timeSelected = editTextTime.getText().toString();
        int selectedRadioButtonId = radioGroupOderType.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            radioButton = findViewById(selectedRadioButtonId);
            orderType = radioButton.getText().toString();
        } else {
            Toast.makeText(MainActivity.this, "select oder type", Toast.LENGTH_SHORT).show();
        }
        if (dateSelected.isEmpty()) {
            Toast.makeText(this, "Select Date", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (timeSelected.isEmpty()) {
            Toast.makeText(this, "Select time", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (orderType.isEmpty()) {
            Toast.makeText(this, "Select order Type", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
