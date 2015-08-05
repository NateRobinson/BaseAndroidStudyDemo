package com.nate.baseandroidstudydemo.activity.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/5.
 */
public class SharedPerferenceMainActivity extends BaseActivity {
    @Bind(R.id.inputDataEt)
    EditText inputDataEt;
    @Bind(R.id.saveBtn)
    Button saveBtn;
    @Bind(R.id.showDataTv)
    TextView showDataTv;
    @Bind(R.id.getDataBtn)
    Button getDataBtn;
    private SharedPreferences preferences;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.sharedperference_main);
    }

    @Override
    public void initListener() {
        saveBtn.setOnClickListener(this);
        getDataBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        preferences = getApplicationContext().getSharedPreferences("com.nate.baseandroid-SharedPerferenceTest", Context.MODE_PRIVATE);
    }

    @Override
    public void bindClick(int viewId) {
        switch (viewId) {
            case R.id.saveBtn:
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("data", inputDataEt.getText().toString());
                editor.apply();//没有线程安全的考虑的话，推荐使用apply
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.getDataBtn:
                String data = preferences.getString("data", "没有存成功");
                showDataTv.setText(data);
                break;
            default:
                break;
        }
    }

}
