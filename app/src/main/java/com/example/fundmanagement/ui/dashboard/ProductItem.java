package com.example.fundmanagement.ui.dashboard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fundmanagement.R;

public class ProductItem extends RecyclerView.ViewHolder {
    TextView productName;
    public ProductItem(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.product_name_tv);
    }
}
