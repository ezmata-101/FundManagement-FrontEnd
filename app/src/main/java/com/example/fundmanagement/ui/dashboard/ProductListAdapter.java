package com.example.fundmanagement.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fundmanagement.R;

import java.util.LinkedList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductItem>{
    private final List<String> DEPOSITS = new LinkedList<>(
            List.of(
                    "Term Deposits",
                    "Fixed Deposit Receipt (FDR)",
                    "Dwigun Sanchaya Prakalpo",
                    "Monthly Profit Based Fixed Deposit (MFD)",
                    "Monthly Profit Based Small Deposit (MPSD)",
                    "Target Based Small Deposit (TBSD)"
            )
    );

    @Override
    public ProductItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.product_item_view, parent, false);
        ProductItem productItem = new ProductItem(productView);
        return productItem;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItem holder, int position) {
        holder.productName.setText(DEPOSITS.get(position));
        final int pos = position;
        holder.productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), DEPOSITS.get(pos), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return DEPOSITS.size();
    }
}