package com.nate.baseandroidstudydemo.activity.fragment;

import android.content.Intent;
import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/4.
 */
public class FragmentMainActivity extends BaseActivity {
    @Bind(R.id.createByXml)
    Button createByXml;
    @Bind(R.id.createByCode)
    Button createByCode;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.fragment_main);
    }

    @Override
    public void initListener() {
        createByXml.setOnClickListener(this);
        createByCode.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindClick(int viewId) {
        Intent intent = new Intent();
        switch (viewId) {
            case R.id.createByCode:
                intent.setClass(this,FragmentWithCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.createByXml:
                intent.setClass(this,FragmentWithXmlActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
