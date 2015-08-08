package com.nate.baseandroidstudydemo.activity.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

/**
 * Created by Nate on 2015/8/4.
 */
public class DialogActivity extends Activity {
    private android.widget.Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        this.backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.backBtn) {
                    finish();
                }
            }
        });
    }
}
