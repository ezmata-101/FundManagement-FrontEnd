package com.example.fundmanagement.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fundmanagement.R;

import java.util.LinkedList;
import java.util.List;

class ProductItemViewHolder extends RecyclerView.ViewHolder {
    TextView productName;
    public ProductItemViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.product_name_tv);
    }
}

public class ProductListAdapter extends RecyclerView.Adapter<ProductItemViewHolder>{
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
    public ProductItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.product_item_view, parent, false);
        ProductItemViewHolder productItem = new ProductItemViewHolder(productView);
        return productItem;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemViewHolder holder, int position) {
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