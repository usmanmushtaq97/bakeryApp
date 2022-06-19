package com.tss.bakeryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.tss.bakeryapp.DBhelperclasses.CartsTableModel;
import com.tss.bakeryapp.DBhelperclasses.DataBaseCarts;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderSummery extends AppCompatActivity {
    TextView tvOrderType, tvDate, tvTime;
    TextView tvName, tvEmail, tvPhone, tvAddress;
    TextView tvPaymentMethod, tvInstruction, tvMessage, tvEventType;
    private RecyclerView mCategoryRV;
    CartsAdapter mCartsAdapter;
    private static List<CartsTableModel> mlist;
    static DataBaseCarts dataBaseCarts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summery);
        init();
        tvName.setText(Constant.NAME);
        dataBaseCarts = DataBaseCarts.getInstance(this);

        Display();
    }
// connect with view
    private void init() {
        tvOrderType = findViewById(R.id.typeoforder_s);
        tvDate = findViewById(R.id.delivery_date_s);
        tvTime = findViewById(R.id.delivery_time_s);
        tvName = findViewById(R.id.name_s);
        tvEmail = findViewById(R.id.email_s);
        tvPhone = findViewById(R.id.phone_s);
        tvAddress = findViewById(R.id.address_s);
        tvPaymentMethod = findViewById(R.id.payment_S);
        tvInstruction = findViewById(R.id.instruction_s);
        tvMessage = findViewById(R.id.message_s);
        tvEventType = findViewById(R.id.event_s);
        mCategoryRV = findViewById(R.id.summary_id_rv);
    }
    // show display summary
    private  void Display(){
         // product details

        mlist = new ArrayList<>();
        mlist = dataBaseCarts.daoCarts().getAll();
        mCartsAdapter = new CartsAdapter(this, mlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mCategoryRV.setLayoutManager(layoutManager);
        mCategoryRV.setAdapter(mCartsAdapter);

        // costumer details
        tvName.setText(MessageFormat.format("Costumer Name:{0}", Constant.NAME));
        tvEmail.setText(MessageFormat.format("Costumer EMAIL:{0}", Constant.EMAIL));
        tvPhone.setText(MessageFormat.format("Costumer Phone:{0}", Constant.PHONE));
        tvAddress.setText(MessageFormat.format("Costumer Address:{0}", Constant.ADDRESS));
        // oder
        tvOrderType.setText(MessageFormat.format("Oder Type:{0}", Constant.orderType));
        tvDate.setText(MessageFormat.format("Date:  {0}", Constant.dateSelected));
        tvTime.setText(MessageFormat.format("Time:{0}", Constant.timeSelected));
        //Payment details
        tvPaymentMethod.setText(MessageFormat.format("Payment Method:{0}", Constant.paymentMethod));
        tvMessage.setText(MessageFormat.format("Message: {0}", Constant.message));
        tvInstruction.setText(MessageFormat.format("Additional Details:{0}", Constant.AdditionalInformation));
        tvEventType.setText(MessageFormat.format("Event Type: {0}", Constant.EventType));
    }

};