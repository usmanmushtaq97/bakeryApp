package com.tss.bakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tss.bakeryapp.DBhelperclasses.CartsTableModel;
import com.tss.bakeryapp.DBhelperclasses.DataBaseCarts;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView viewTitle;
    TextView viewPrice;
    TextView viewQty;
    Spinner sizeSpinner;
    // CheckBox checkBoxFlavorChocolate;
    Button incrementButton, decrementButton;
    Button addToCardButton;
    String title;
    static String psize;
    DataBaseCarts dataBase;
    static int qty = 1;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        dataBase = DataBaseCarts.getInstance(ProductDetails.this);
        init();
        getInit();
        setDate();

        // Spinner click listener
        sizeSpinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> sizeList = new ArrayList<String>();
        sizeList.add("Small");
        sizeList.add("Medium");
        sizeList.add("Large");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizeList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sizeSpinner.setAdapter(dataAdapter);
        //on click on qty btn+
        incrementButton.setOnClickListener(v -> {
            qty++;
            viewQty.setText(String.valueOf(qty));
        });
        decrementButton.setOnClickListener(v -> {
            if (qty > 1) {
                qty--;
                viewQty.setText(String.valueOf(qty));
            }
        });

        addToCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataInDB();
                Toast.makeText(ProductDetails.this, title+"Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
  // bind to view
    private void init() {
        viewPrice = findViewById(R.id.textView_price_);
        viewTitle = findViewById(R.id.product_title_);
        viewQty = findViewById(R.id.textView_qty);
        sizeSpinner = findViewById(R.id.spinner_size);
        addToCardButton = findViewById(R.id.button_add_to_card);
        incrementButton = findViewById(R.id.button_increase);
        decrementButton = findViewById(R.id.button_less);
    }
  // get data from adapter
    private void getInit() {
        Intent intent = getIntent();
        title = intent.getStringExtra("name");
        price = intent.getIntExtra("price", 0);
        Toast.makeText(this, "" + title + price, Toast.LENGTH_SHORT).show();
    }
   // set data on view
    private void setDate() {
        viewPrice.setText("$" + String.valueOf(price));
        viewTitle.setText(title);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      psize = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, ""+psize, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    // add data to sqlite
    private void AddDataInDB() {
        String pqty = viewQty.getText().toString();
        int qtyupdate = Integer.parseInt(pqty);
        int subPrice = qtyupdate * price;
        //Toast.makeText(this, ""+psize, Toast.LENGTH_SHORT).show();
        dataBase.daoCarts().InsertCarts(new CartsTableModel(title, qtyupdate, price, subPrice,psize));
    }
}