package com.nate.baseandroidstudydemo.activity.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nate.baseandroidstudydemo.R;

/**
 * Created by Nate on 2015/8/5.
 */
class MyAdapter extends RecyclerView.Adapter {

    private ValueData[] valueDatas = new ValueData[]{new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容"), new ValueData("标题", "这是内容")};

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv;
        private TextView contentTv;

        public MyViewHolder(View root) {
            super(root);
            titleTv = (TextView) root.findViewById(R.id.titleTv);
            contentTv = (TextView) root.findViewById(R.id.contentTv);
        }

        public TextView getTitleTv() {
            return titleTv;
        }

        public TextView getContentTv() {
            return contentTv;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_layout, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.getContentTv().setText(valueDatas[i].getContent() + i);
        myViewHolder.getTitleTv().setText(valueDatas[i].getTitle() + i);
    }

    @Override
    public int getItemCount() {
        return valueDatas != null ? valueDatas.length : 0;
    }
}
