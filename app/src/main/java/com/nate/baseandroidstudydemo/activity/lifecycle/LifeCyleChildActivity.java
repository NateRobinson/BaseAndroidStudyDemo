package com.nate.baseandroidstudydemo.activity.lifecycle;

import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/4.
 * 用来测试Activity的Stoped生命周期的辅助子类
 */
public class LifeCyleChildActivity extends BaseActivity {
    @Bind(R.id.backBtn)
    Button backBtn;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.life_cycle_child);
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
