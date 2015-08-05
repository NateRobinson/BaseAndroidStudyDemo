package com.nate.baseandroidstudydemo.activity.recyclerview;

/**
 * Created by Nate on 2015/8/5.
 * listview 展示对象实体类
 */
public class ValueData {

    private String title;
    private String content;

    public ValueData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
