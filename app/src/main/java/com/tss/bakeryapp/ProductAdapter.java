package com.tss.bakeryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter< ProductAdapter.ViewHolder > {

    private Context mContext;
    private List< ProductModel > modelList;

    public ProductAdapter(Context context, List< ProductModel > builderItems) {
        this.mContext = context;
        this.modelList = builderItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModel modelPos = this.modelList.get(position);
        holder.viewTitle.setText(modelPos.productTitle);
        holder.viewPrice.setText("Price   $"+String.valueOf(modelPos.price));
        holder.imageView.setImageResource(modelPos.ProductImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductDetails.class);
                intent.putExtra("pid", modelPos.getId());
                intent.putExtra("name", modelPos.getProductTitle());
                intent.putExtra("price", modelPos.getPrice());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView viewTitle;
        public TextView viewPrice;
        ImageView imageView;
        LinearLayout layout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPrice = itemView.findViewById(R.id.price_product);
            viewTitle = itemView.findViewById(R.id.title_product);
            imageView = itemView.findViewById(R.id.product_image);
            layout = itemView.findViewById(R.id.layout_id);

        }
    }


}