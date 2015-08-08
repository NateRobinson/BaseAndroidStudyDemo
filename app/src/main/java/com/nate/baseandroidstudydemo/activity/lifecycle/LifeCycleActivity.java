package com.nate.baseandroidstudydemo.activity.lifecycle;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/4.
 * Activity生命周期测试类
 */
public class LifeCycleActivity extends BaseActivity {
    private static final String TAG = "LifeCycleActivity";
    @Bind(R.id.pauseAndResumeBtn)
    Button pauseAndResumeBtn;
    @Bind(R.id.stopAndRestartBtn)
    Button stopAndRestartBtn;
    @Bind(R.id.destroyBtn)
    Button destroyBtn;

    @Override
    public void initContentLayout() {
        Log.d(TAG, "------onCreate------");
        setContentView(R.layout.life_cycle_main);
    }

    @Override
    public void initListener() {
        pauseAndResumeBtn.setOnClickListener(this);
        stopAndRestartBtn.setOnClickListener(this);
        destroyBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void bindClick(int viewId) {
        Intent intent=new Intent();
        switch (viewId) {
            case R.id.pauseAndResumeBtn:
                intent.setClass(this, DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.stopAndRestartBtn:
                intent.setClass(this, LifeCyleChildActivity.class);
                startActivity(intent);
                break;
            case R.id.destroyBtn:
                finish();
                break;
            default:
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "------onSaveInstanceState------");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "------onRestoreInstanceState------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "------onRestart------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "-----onStart------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "------onResume------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "------onPause------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "------onStop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "------onDestroy------");
    }
}
