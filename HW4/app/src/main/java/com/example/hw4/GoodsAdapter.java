package com.example.hw4;

import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class GoodsAdapter implements ListAdapter {
    private Good[] goods;

    public GoodsAdapter(Good[] goods){
        super();
        this.goods = goods;
    }

       @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return this.goods.length;
    }

    @Override
    public Object getItem(int position) {
        return this.goods[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 檢查convertView是否有值，有值表示是重複使用的
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_list_item, null);
        }

        // 找到name and price TextView
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        // 取出Good類別
        Log.v("Position", Integer.toString(position));
        Good good = this.goods[position];
        name.setText(good.getName());
        price.setText(String.valueOf(good.getPrice()));
        // 找到ImageView
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        int resId = good.getImage();
         image.setImageResource(good.getImage());
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
