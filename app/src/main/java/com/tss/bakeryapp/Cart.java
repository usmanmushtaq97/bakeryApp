package com.tss.bakeryapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tss.bakeryapp.DBhelperclasses.CartsTableModel;
import com.tss.bakeryapp.DBhelperclasses.DataBaseCarts;

import java.util.ArrayList;
import java.util.List;
public class Cart extends Fragment {
    private Context mContext;
    private RecyclerView mCategoryRV;
    private CartsAdapter mCartsAdapter;
    private static List<CartsTableModel> mlist;
    private TextView tv_totalprice;
    private View view;
    CardView cartsdetailslayout;
    LinearLayout constraintLayout;
    static DataBaseCarts dataBaseCarts;
    TextView subtotal;
    Button checkout;
    Button continueShoping;
    public void Carts() {
        // Required empty public constructor
    }
    // attach context
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // access the data base instance
        dataBaseCarts = DataBaseCarts.getInstance(mContext);
        view = inflater.inflate(R.layout.fragment_carts, container, false);
        //Inflate the layout for this fragment
        ConviewWithId();
        mlist = new ArrayList<>();
        mlist = dataBaseCarts.daoCarts().getAll();
        mCartsAdapter = new CartsAdapter(mContext, mlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mCategoryRV.setLayoutManager(layoutManager);
        mCategoryRV.setAdapter(mCartsAdapter);
        mCartsAdapter.notifyDataSetChanged();
        ShopingContinue();
        AddItemCount();
        // Toast.makeText(mContext, "total" + TotalPriceCount(), Toast.LENGTH_SHORT).show();
        tv_totalprice.setText(String.valueOf(TotalPriceCount()) + "$");
        subtotal.setText(String.valueOf(TotalPriceCount()) + "$");
        checkout = view.findViewById(R.id.bt_check_out);
        checkout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Are you Ready For CheckOut")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialog, id) -> {
                            Toast.makeText(mContext, "c", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(mContext, MainActivity.class);
                            mContext.startActivity(intent);

                        })
                        .setNegativeButton("No", (dialog, id) -> dialog.cancel());
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return view;
    }
    // count the how many item in carts

    private void AddItemCount() {
        mCartsAdapter.ViabilityCarts(cartsdetailslayout,constraintLayout);
    }
    //connection with view
    private void ConviewWithId() {
        mCategoryRV = view.findViewById(R.id.cartsitem);
        subtotal = view.findViewById(R.id.subtotal);
        constraintLayout = view.findViewById(R.id.cartbg);
        cartsdetailslayout = view.findViewById(R.id.carts_details_item);
        tv_totalprice = view.findViewById(R.id.totalprice);
        continueShoping = view.findViewById(R.id.continueShoping_id);
    }
    //let get start other shopping
    private void ShopingContinue(){
        continueShoping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HomeActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
    // this method calculate the  total price
    public static int TotalPriceCount() {
        int totalprice = 0;
        int shiping = 0;
        mlist = dataBaseCarts.daoCarts().getAll();
        for (CartsTableModel dataBaseCarts : mlist) {
            totalprice += dataBaseCarts.getMprice();
        }

        return totalprice+shiping;
    }
}