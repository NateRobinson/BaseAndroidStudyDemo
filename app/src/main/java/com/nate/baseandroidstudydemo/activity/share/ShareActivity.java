package com.nate.baseandroidstudydemo.activity.share;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/11.
 * 简单的与其他应用分享数据的例子
 * 这里要先在模拟器或者设备上运行project中的另一个项目handlesharedata
 */
public class ShareActivity extends BaseActivity {
    @Bind(R.id.sendDataBtn)
    Button sendDataBtn;
    private Uri uri;
    private SimpleDraweeView mSimpleDraweeView;

    @Override
    public void initContentLayout() {
        Fresco.initialize(this);
        setContentView(R.layout.share_main);
        mSimpleDraweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        uri = Uri.parse("http://img4q.duitang.com/uploads/item/201502/25/20150225172743_x2hfW.jpeg");
        mSimpleDraweeView.setImageURI(uri);

    }

    @Override
    public void initListener() {
        sendDataBtn.setOnClickListener(this);
        mSimpleDraweeView.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void bindClick(int viewId) {
        if (viewId == R.id.sendDataBtn) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
//          startActivity(sendIntent);
            startActivity(Intent.createChooser(sendIntent, "能接收数据的应用"));
        } else if (viewId == R.id.my_image_view) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.setType("image/jpeg");
            startActivity(Intent.createChooser(intent, "选择分享图片的应用"));
        }
    }

}
