package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class DescriptionActivity extends AppCompatActivity {
  TextView name;
  TextView price;
  ImageView image;
  EditText description;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_description);
    init();

  }

  public void init() {
    name = findViewById(R.id.description_name);
    price = findViewById(R.id.description_price);
    description = findViewById(R.id.description);
    image = findViewById(R.id.description_image);

    Intent intent = getIntent();
    name.setText(intent.getStringExtra("name"));
    price.setText(String.valueOf(intent.getIntExtra("price", 0)));
    image.setImageResource(intent.getIntExtra("image", 0));
    description.setText("  " + intent.getStringExtra("description"));
  }
}
