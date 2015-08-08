package com.nate.baseandroidstudydemo.activity.recyclerview;

import android.content.Intent;
import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/5.
 */
public class RecyclerViewMain extends BaseActivity {

    @Bind(R.id.listViewBtn)
    Button listViewBtn;
    @Bind(R.id.gridViewBtn)
    Button gridViewBtn;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.recyclerview_main);
    }

    @Override
    public void initListener() {
        listViewBtn.setOnClickListener(this);
        gridViewBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void bindClick(int viewId) {
        Intent intent=new Intent();
        switch (viewId) {
            case R.id.listViewBtn:
                intent.setClass(this,ListRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.gridViewBtn:
                intent.setClass(this,GridRecyclerViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
