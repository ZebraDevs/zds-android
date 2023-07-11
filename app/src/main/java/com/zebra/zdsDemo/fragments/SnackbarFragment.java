package com.zebra.zdsDemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.zebra.zdsDemo.R;

public class SnackbarFragment extends Fragment {

    public SnackbarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_snackbar, container, false);

        root.findViewById(R.id.show_snackbar).setOnClickListener(v -> Snackbar.make(root.findViewById(R.id.snackbarLayout), "This is a snackbar", 1000)
                .setAction("Action", action -> { })
                .show());

        return root;
    }
}