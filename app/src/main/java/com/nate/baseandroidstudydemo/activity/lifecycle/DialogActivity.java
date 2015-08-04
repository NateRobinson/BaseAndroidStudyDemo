package com.nate.baseandroidstudydemo.activity.lifecycle;

import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

/**
 * Created by Nate on 2015/8/4.
 */
public class DialogActivity extends BaseActivity {
    private android.widget.Button backBtn;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.dialog_layout);
        this.backBtn = (Button) findViewById(R.id.backBtn);
    }

    @Override
    public void initListener() {
        backBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindClick(int viewId) {
        if (viewId == R.id.backBtn) {
            finish();
        }
    }
}
