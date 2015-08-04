package com.nate.baseandroidstudydemo.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nate.baseandroidstudydemo.R;

/**
 * Created by Nate on 2015/8/4.
 */
public class FragmentForCodeA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_to_code_a, container, false);
    }
}
