package com.tss.bakeryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.tss.bakeryapp.DBhelperclasses.CartsTableModel;


import java.util.List;

public class CartsAdapter extends RecyclerView.Adapter<CartsAdapter.MyViewHolder> {
    Context mContex;
    List<CartsTableModel> mList;
    View view;
    public CartsAdapter(Context mCintex, List<CartsTableModel> mList) {
        this.mContex = mCintex;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContex).inflate(R.layout.cartsitems, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder,  int position) {
        //dataBase = DataBaseCarts.getInstance(mContex);
         CartsTableModel rowp = mList.get(position);
        holder.mCartsProductstitle.setText(rowp.getMproductname());
        holder.mCartsSize_item.setText(rowp.getPsize());
        holder.mCartsPrice_item.setText(String.valueOf(rowp.getMprice()));
        holder.mCarts_item_Quantity.setText(String.valueOf(rowp.getMqunatity_product()));


    }
    // this method count the size of adapter
    @Override
    public int getItemCount() {

        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mCartsProductstitle;
        ImageView mCarts_ImageView;
        TextView mCartsSize_item;
        TextView mCartsPrice_item;
        TextView mCarts_item_Quantity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCarts_ImageView = itemView.findViewById(R.id.carts_Image);
            mCartsProductstitle = itemView.findViewById(R.id.carts_titleproduct_tv);
            mCartsSize_item = itemView.findViewById(R.id.carts_size_tv);
            mCartsPrice_item = itemView.findViewById(R.id.carts_price_tv);
            mCarts_item_Quantity = itemView.findViewById(R.id.quantity_products);
        }
    }
/// it now show empty card when the item is empty
    public void ViabilityCarts(CardView linearLayout, LinearLayout layout) {
        if (mList.size() > 0) {
            linearLayout.setVisibility(View.VISIBLE);
            layout.setVisibility(View.GONE);
        } else {
            layout.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);

        }
    }
}

