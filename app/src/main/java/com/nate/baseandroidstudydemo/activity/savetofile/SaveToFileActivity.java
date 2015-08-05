package com.nate.baseandroidstudydemo.activity.savetofile;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nate.baseandroidstudydemo.R;
import com.nate.baseandroidstudydemo.base.BaseActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.Bind;

/**
 * Created by Nate on 2015/8/5.
 * 测试文件内部存储和外部sdcard存储
 */
public class SaveToFileActivity extends BaseActivity {
    @Bind(R.id.inputDataEt)
    EditText inputDataEt;
    @Bind(R.id.saveBtn)
    Button saveBtn;
    @Bind(R.id.showDataTv)
    TextView showDataTv;
    @Bind(R.id.getDataBtn)
    Button getDataBtn;
    @Bind(R.id.spinner)
    Spinner spinner;
    private int type = 0;

    @Override
    public void initContentLayout() {
        setContentView(R.layout.file_main);
    }

    @Override
    public void initListener() {
        saveBtn.setOnClickListener(this);
        getDataBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        // 建立数据源
        String[] mItems = getResources().getStringArray(R.array.fileType);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        //绑定 Adapter到控件
        spinner.setAdapter(mAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                type = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public void bindClick(int viewId) {
        switch (viewId) {
            case R.id.saveBtn:
                if (type == 0) {
                    saveInternalStorage();
                } else if (type == 1) {
                    saveExternalStoragePublic();
                }
                break;
            case R.id.getDataBtn:
                if (type == 0) {
                    getInternalStorage();
                } else if (type == 1) {
                    getExternalStoragePublic();
                }
                break;
            default:
                break;
        }
    }

    //从外部存储获取公有的存储文件
    private void getExternalStoragePublic() {
        File file = new File(Environment.getExternalStorageDirectory(), "ExternalStoragePublicTest");
        File file2 = new File(file, "data.txt");
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file2);
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        showDataTv.setText(content.toString());
    }

    //从内部存储中读取数据
    private void getInternalStorage() {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            fileInputStream = this.openFileInput("data.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        showDataTv.setText(content.toString());
    }

    //保存到外部公有区域
    private void saveExternalStoragePublic() {
        File file = getAlbumStorageDirPublic("ExternalStoragePublicTest");
        File file2 = new File(file, "data.txt");
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(inputDataEt.getText().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //保存到内部区域
    private void saveInternalStorage() {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = this.openFileOutput("data.txt", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(inputDataEt.getText().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //创建sdcard文件夹
    public File getAlbumStorageDirPublic(String albumName) {
        Log.d("guxuewu", Environment.getExternalStorageDirectory() + "");
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStorageDirectory(), albumName);
        if (!file.mkdirs()) {
            Toast.makeText(this, "文件夹创建失败", Toast.LENGTH_SHORT).show();
        }
        return file;
    }
}
