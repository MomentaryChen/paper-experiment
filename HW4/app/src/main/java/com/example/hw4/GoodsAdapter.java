package com.example.hw4;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodsAdapter implements Adapter {
    private Good[] goods;

    public GoodsAdapter(Good[] goods){
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
            // 沒有值就要自己建立一個
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_list_item, null);
        }

        // 找到TextView
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        // 取出文字
        Good good = this.goods[position];
        // 將文字內容設定給TextView
        name.setText(good.getName());
        price.setText(good.getPrice());

        // 找到ImageView
        ImageView icon = (ImageView) convertView.findViewById(R.id.image);
        // 依照位置算出對應的圖片

        // ==================================================================================================
        int resId = mIcons[position % mIcons.length];
        // 將圖片設定給ImageView
        icon.setImageResource(resId);

        // 一定要將convertView回傳，供ListView呈現使用，並加入重用機制中
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
