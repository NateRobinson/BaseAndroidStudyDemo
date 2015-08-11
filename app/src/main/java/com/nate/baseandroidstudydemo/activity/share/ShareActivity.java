package com.nate.baseandroidstudydemo.activity.share;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nate.baseandroidstudydemo.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Nate on 2015/8/11.
 * 简单的与其他应用分享数据的例子
 * 这里要先在模拟器或者设备上运行project中的另一个项目handlesharedata
 */
public class ShareActivity extends Activity implements View.OnClickListener {
    @Bind(R.id.sendDataBtn)
    Button sendDataBtn;
    private Uri uri;
    private SimpleDraweeView mSimpleDraweeView;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentLayout();
        ButterKnife.bind(this);
        initListener();
        initData();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
    }

    public void initContentLayout() {
        Fresco.initialize(this);
        setContentView(R.layout.share_main);
        mSimpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        uri = Uri.parse("http://img4q.duitang.com/uploads/item/201502/25/20150225172743_x2hfW.jpeg");
        mSimpleDraweeView.setImageURI(uri);

    }

    public void initListener() {
        sendDataBtn.setOnClickListener(this);
        mSimpleDraweeView.setOnClickListener(this);
    }

    public void initData() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sendDataBtn) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "能接收数据的应用"));
        } else if (v.getId() == R.id.my_image_view) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.setType("image/jpeg");
            startActivity(Intent.createChooser(intent, "选择分享图片的应用"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_main, menu);
        MenuItem item = menu.findItem(R.id.share);
        // Fetch and store ShareActionProvider
        if (item != null) {
            mShareActionProvider = (ShareActionProvider) item.getActionProvider();
            if (!setShareIntent()) {
                menu.removeItem(R.id.share);
                //如果没有第3方应用可以直接用，
                //可以添加一个新的菜单项，可以跳转到自己的activity，然后处理等
            } else {
                Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    private boolean setShareIntent() {
        if (mShareActionProvider != null) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.setType("image/jpeg");
            PackageManager pm = getPackageManager();
            //检查手机上是否存在可以处理这个动作的应用
            List<ResolveInfo> infolist = pm.queryIntentActivities(intent, 0);
            if (!infolist.isEmpty()) {
                mShareActionProvider.setShareIntent(intent);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
