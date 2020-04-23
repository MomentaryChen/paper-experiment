package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {
    ListView goods ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    private void init() {
        goods = findViewById(R.id.goods);
        String[] values = new String[]{
                "TV",
                "Computer",
                "Screen",
                "Mouse"
        };
        ListAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,values);
        goods.setAdapter(adapter);
    }
}
