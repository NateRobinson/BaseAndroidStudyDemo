package com.nate.baseandroidstudydemo.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.nate.baseandroidstudydemo.R;

/**
 * Created by Nate on 2015/8/4.
 */
public class FragmentA extends Fragment {

    private MyCallBackListener listener;
    private View view;

    public static interface MyCallBackListener {
        public void valueToActivity(String value);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (MyCallBackListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implments MyCallBackListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final EditText editText= (EditText) view.findViewById(R.id.valueEt);
        view.findViewById(R.id.gotoBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.valueToActivity(editText.getText().toString());
            }
        });
    }
}
