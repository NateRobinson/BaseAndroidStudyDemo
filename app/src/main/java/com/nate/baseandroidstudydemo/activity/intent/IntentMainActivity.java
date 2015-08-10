package com.nate.baseandroidstudydemo.activity.intent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/10.
 */
public class IntentMainActivity extends BaseActivity {
    static final int PICK_CONTACT_REQUEST = 1;  // The request code
    @Bind(R.id.implicitIntentForMapBtn)
    Button implicitIntentForMapBtn;
    @Bind(R.id.implicitIntentForEmailBtn)
    Button implicitIntentForEmailBtn;
    @Bind(R.id.openActWithResultBtn)
    Button openActWithResultBtn;
    @Bind(R.id.resultTv)
    TextView resultTv;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.intent_main);
    }

    @Override
    public void initListener() {
        implicitIntentForMapBtn.setOnClickListener(this);
        implicitIntentForEmailBtn.setOnClickListener(this);
        openActWithResultBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindClick(int viewId) {
        if (viewId == R.id.implicitIntentForMapBtn) {
            Intent mapIntent = null;
            try {
                //通过intent打开百度地图app
                mapIntent = Intent.getIntent("intent://map/marker?location=40.047669,116.313082&title=我的位置&content=百度奎科大厦&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            if (null != mapIntent && isHaveLeastOneAppForOpen(mapIntent)) {
                startActivity(mapIntent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("没有可以打开的应用").setNegativeButton("取消", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        } else if (viewId == R.id.implicitIntentForEmailBtn) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc882");
            //发给谁
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jon@example.com"}); // recipients
            //邮件标题
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
            //邮件内容
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
            if (isHaveLeastOneAppForOpen(emailIntent)) {
                startActivity(emailIntent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("没有可以打开的应用").setNegativeButton("取消", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        } else if (viewId == R.id.openActWithResultBtn) {
            Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
            pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
            startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
        }
    }

    /**
     * 判断一个应用是否安装--1
     *
     * @param packageName
     * @return
     */
    private boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }


    /**
     * 判断是否有至少一个应用 可以打开目标intent --2
     */
    private boolean isHaveLeastOneAppForOpen(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri contactData = data.getData();
                Cursor c = getContentResolver().query(contactData, null, null, null, null);
                if (c.moveToFirst()) {
                    resultTv.setText("");
                    resultTv.append("DISPLAY_NAME=>" + c.getString(c.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)) + "; ");
                    resultTv.append("NUMBER=>" + c.getString(c.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                }
            }
        }
    }
}
