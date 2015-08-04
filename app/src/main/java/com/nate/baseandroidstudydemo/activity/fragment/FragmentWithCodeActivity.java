package com.nate.baseandroidstudydemo.activity.fragment;

import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/4.
 */
public class FragmentWithCodeActivity extends BaseActivity {
    @Bind(R.id.changeBtn)
    Button changeBtn;
    FragmentForCodeA fragmentForCodeA;
    FragmentForCodeB fragmentForCodeB;
    private int currentFragment=1;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.fragment_with_code_layout);
    }

    @Override
    public void initListener() {
        changeBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        changeBtn.setText("点击按钮，加入FragmentA");
        fragmentForCodeA = new FragmentForCodeA();
        fragmentForCodeB = new FragmentForCodeB();
        getSupportFragmentManager().beginTransaction().add(R.id.content, fragmentForCodeA).commit();
        changeBtn.setText("点击按钮，replace A to B");
    }

    @Override
    public void bindClick(int viewId) {
        if (viewId == R.id.changeBtn) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragmentForCodeB).addToBackStack(null).commit();
            changeBtn.setText("点击返回键返回FragmentA");
            changeBtn.setClickable(false);
            currentFragment=2;
        }
    }

    @Override
    public void onBackPressed() {
        if(currentFragment==2){
            changeBtn.setClickable(true);
            changeBtn.setText("点击按钮，replace A to B");
        }
        super.onBackPressed();
    }
}
