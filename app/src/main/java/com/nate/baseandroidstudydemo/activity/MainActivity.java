package com.nate.baseandroidstudydemo.activity;

import android.content.Intent;
import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.activity.lifecycle.LifeCycleActivity;
import com.nate.baseandroidstudydemo.activity.lifecycle.LifeCyleChildActivity;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.activityLifeCycleBtn)
    Button activityLifeCycleBtn;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initListener() {
        activityLifeCycleBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindClick(int viewId) {
        Intent intent = new Intent();
        switch (viewId) {
            case R.id.activityLifeCycleBtn:
                intent.setClass(MainActivity.this, LifeCycleActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
