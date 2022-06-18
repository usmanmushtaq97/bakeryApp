package com.tss.bakeryapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

   ProductAdapter productAdapter;
   List<ProductModel> modelList;
   Context mContext;
   RecyclerView recyclerView;
   View view;
    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rv_product);
        modelList = new ArrayList<>();
        modelList.add(new ProductModel(1,3,"Cupcakes (RM2.00)",1,R.drawable.placeholderimages));
        modelList.add(new ProductModel(1,4,"Cookies",1,R.drawable.placeholderimages));
        modelList.add(new ProductModel(1,2,"Doughnuts",1,R.drawable.placeholderimages));
        modelList.add(new ProductModel(1,4,"Rolls",1,R.drawable.placeholderimages));
        modelList.add(new ProductModel(1,4,"Doughnuts (RM3.50)",1,R.drawable.placeholderimages));
        modelList.add(new ProductModel(1,4,"Cakes(Small-RM35.00-Big–RM50.00)",1,R.drawable.placeholderimages));
        GridLayoutManager layoutManager = new GridLayoutManager(mContext,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(mContext, modelList);
        recyclerView.setAdapter(productAdapter);
        return view;
    }
}