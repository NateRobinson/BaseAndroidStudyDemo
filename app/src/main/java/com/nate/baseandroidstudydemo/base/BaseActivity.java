package com.nate.baseandroidstudydemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nate.baseandroidstudydemo.R;

import butterknife.ButterKnife;

/**
 * Created by Nate on 2015/7/24.
 * 整个应用的基本Activity，用来规范代码结构和统一初始化一些数据
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initContentLayout();
        ButterKnife.bind(this);
        initListener();
        initData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                bindClick(v.getId());
                break;
        }
    }

    //初始化子类的布局文件
    public abstract void initContentLayout();

    //监听回调的初始化设置
    public abstract void initListener();

    //初始化数据
    public abstract void initData();

    //子类实现，用来进行点击事件的监听
    public abstract void bindClick(int viewId);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
