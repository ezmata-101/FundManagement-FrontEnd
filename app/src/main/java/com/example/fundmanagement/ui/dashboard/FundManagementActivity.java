package com.example.fundmanagement.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fundmanagement.R;
import com.example.fundmanagement.data.ProductRepository;

import java.util.List;

public class FundManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_management);

        RecyclerView recyclerView = findViewById(R.id.product_list);
        ProductListAdapter adapter = new ProductListAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ProductRepository.get().getProducts().observe(this, products -> {
            adapter.setDEPOSITS(products);
            adapter.notifyDataSetChanged();
        });

        Toast.makeText(this, "Fund Management Activity", Toast.LENGTH_SHORT).show();
    }
}