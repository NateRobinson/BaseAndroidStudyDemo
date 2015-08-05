package com.nate.baseandroidstudydemo.activity.recyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/5.
 */
public class GridRecyclerViewActivity extends BaseActivity {
    @Bind(R.id.rv)
    RecyclerView rv;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.recycler_list_layout);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setAdapter(new MyAdapter());
    }

    @Override
    public void bindClick(int viewId) {

    }

}
