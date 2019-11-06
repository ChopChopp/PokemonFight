package com.example.myapplication;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class second_fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_second_fragment, container, false);
    }
}
