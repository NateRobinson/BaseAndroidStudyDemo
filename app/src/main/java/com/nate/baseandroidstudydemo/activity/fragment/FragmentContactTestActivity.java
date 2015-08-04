package com.nate.baseandroidstudydemo.activity.fragment;

import android.os.Bundle;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

/**
 * Created by Nate on 2015/8/4.
 */
public class FragmentContactTestActivity extends BaseActivity implements FragmentA.MyCallBackListener {
    @Override
    public void initContentLayout() {
        setContentView(R.layout.fragment_contact_layout);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getSupportFragmentManager().beginTransaction().add(R.id.content, new FragmentA()).commit();
    }

    @Override
    public void bindClick(int viewId) {

    }

    @Override
    public void valueToActivity(String value) {
        FragmentB fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("value", value);
        fragmentB.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragmentB).addToBackStack(null).commit();
    }
}
