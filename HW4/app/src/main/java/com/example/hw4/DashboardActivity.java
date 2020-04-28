package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {
    ListView goodsList;
    ImageButton bi;
    public final Good [] goods = {
            new Good("TV", 20000, "Test TV",R.drawable.tv),
            new Good("Computer", 30000, "Test Computer",R.drawable.computer),
            new Good("Screen", 3500, "Test Screen" ,R.drawable.screen),
            new Good("Mouse", 1000,"Test Mouse", R.drawable.mouse),
            new Good("Keyboard", 1500, "Test Keyboard",R.drawable.keyboard)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void init() {
        goodsList = findViewById(R.id.goods);
        goodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(DashboardActivity.this, DescriptionActivity.class);
                intent.putExtra("name", goods[position].getName());
                intent.putExtra("price", goods[position].getPrice());
                intent.putExtra("image", goods[position].getImage());
                intent.putExtra("description", goods[position].getDescription());
                startActivity(intent);
            }
        });

        GoodsAdapter adapter = new GoodsAdapter(goods, this);
        goodsList.setAdapter(adapter);
    }

}
