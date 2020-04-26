package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {
    ListView goodsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void init() {
        goodsList = findViewById(R.id.goods);
        Good [] goods = {
                new Good("TV", 20000, R.drawable.tv),
                new Good("Computer", 30000, R.drawable.computer),
                new Good("Screen", 3500, R.drawable.screen),
                new Good("Mouse", 1000, R.drawable.mouse),
                new Good("Keyboard", 1500, R.drawable.keyboard)
        };
        GoodsAdapter adapter = new GoodsAdapter(goods);
        goodsList.setAdapter(adapter);
    }
}
