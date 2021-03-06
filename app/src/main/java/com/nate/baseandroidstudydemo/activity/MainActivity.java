package com.nate.baseandroidstudydemo.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.activity.fragment.FragmentMainActivity;
import com.nate.baseandroidstudydemo.activity.intent.IntentMainActivity;
import com.nate.baseandroidstudydemo.activity.lifecycle.LifeCycleActivity;
import com.nate.baseandroidstudydemo.activity.recyclerview.RecyclerViewMain;
import com.nate.baseandroidstudydemo.activity.savetofile.SaveToFileActivity;
import com.nate.baseandroidstudydemo.activity.share.ShareActivity;
import com.nate.baseandroidstudydemo.activity.sharedpreference.SharedPerferenceMainActivity;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    private Toast toast;

    @Bind(R.id.activityLifeCycleBtn)
    Button activityLifeCycleBtn;
    @Bind(R.id.fragmentBtn)
    Button fragmentBtn;
    @Bind(R.id.rvBtn)
    Button rvBtn;
    @Bind(R.id.sharedperferenceBtn)
    Button sharedperferenceBtn;
    @Bind(R.id.fileSaveBtn)
    Button fileSaveBtn;
    @Bind(R.id.intentuseBtn)
    Button intentuseBtn;
    @Bind(R.id.shareBtn)
    Button shareBtn;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void initListener() {
        activityLifeCycleBtn.setOnClickListener(this);
        fragmentBtn.setOnClickListener(this);
        rvBtn.setOnClickListener(this);
        sharedperferenceBtn.setOnClickListener(this);
        fileSaveBtn.setOnClickListener(this);
        intentuseBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        toast = Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void bindClick(int viewId) {
        Intent intent = new Intent();
        switch (viewId) {
            case R.id.activityLifeCycleBtn:
                intent.setClass(MainActivity.this, LifeCycleActivity.class);
                startActivity(intent);
                break;
            case R.id.fragmentBtn:
                intent.setClass(MainActivity.this, FragmentMainActivity.class);
                startActivity(intent);
                break;
            case R.id.rvBtn:
                intent.setClass(MainActivity.this, RecyclerViewMain.class);
                startActivity(intent);
                break;
            case R.id.sharedperferenceBtn:
                intent.setClass(MainActivity.this, SharedPerferenceMainActivity.class);
                startActivity(intent);
                break;
            case R.id.fileSaveBtn:
                intent.setClass(MainActivity.this, SaveToFileActivity.class);
                startActivity(intent);
                break;
            case R.id.intentuseBtn:
                intent.setClass(MainActivity.this, IntentMainActivity.class);
                startActivity(intent);
                break;
            case R.id.shareBtn:
                intent.setClass(MainActivity.this, ShareActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (null == toast.getView().getParent()) {
            toast.show();
        } else {
            finish();
            System.exit(0);
        }
    }
}
