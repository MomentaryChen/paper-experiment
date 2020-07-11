package com.example.hw4;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class GoodsAdapter extends BaseAdapter {
  private Good[] Goods;
  private Context context;

  public GoodsAdapter(Good[] goods, Context context) {
    super();
    this.Goods = goods;
    this.context = context;
  }

  @Override
  public int getCount() {
    return this.Goods.length;
  }

  @Override
  public Object getItem(int position) {
    return this.Goods[position];
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // 檢查convertView是否有值，有值表示是重複使用的
    LayoutInflater inflater = LayoutInflater.from(context);
    LinearLayout itemlayout = null;

    if (convertView == null) {
      itemlayout = (LinearLayout) inflater.inflate(R.layout.goods_list_item, null);
    } else {
      itemlayout = (LinearLayout) convertView;
    }
    Good good = this.Goods[position];
    TextView name = (TextView) itemlayout.findViewById(R.id.name);
    name.setText(good.getName());
    TextView price = (TextView) itemlayout.findViewById(R.id.price);
    // 取出Good類別
    price.setText(String.valueOf(good.getPrice()));
    // 找到ImageView
    ImageView image = (ImageView) itemlayout.findViewById(R.id.image);
    image.setImageResource(good.getImage());

    return itemlayout;
  }
}
