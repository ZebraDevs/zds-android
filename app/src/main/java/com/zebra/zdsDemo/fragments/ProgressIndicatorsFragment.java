package com.zebra.zdsDemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.Fragment;

import com.zebra.zdsDemo.R;
import com.zebra.zds.ZdsCircularProgressIndicator;
import com.zebra.zds.ZdsLinearProgressIndicator;

public class ProgressIndicatorsFragment extends Fragment {

    AppCompatSeekBar seekBar;
    ZdsLinearProgressIndicator linearIndicator1;
    ZdsLinearProgressIndicator linearIndicator2;
    ZdsLinearProgressIndicator linearIndicator3;
    ZdsCircularProgressIndicator circularProgressIndicator1;

    public ProgressIndicatorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_progress_indicators, container, false);

        seekBar = root.findViewById(R.id.progressSeekBar);
        linearIndicator1 = root.findViewById(R.id.progressIndicatorLinear);
        linearIndicator2 = root.findViewById(R.id.progressIndicatorLinearMedium);
        linearIndicator3 = root.findViewById(R.id.progressIndicatorLinearNoLabel);
        circularProgressIndicator1 = root.findViewById(R.id.progressIndicatorCircular);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        setProgress(seekBar.getProgress());
    }

    private void setProgress(int progress) {
        linearIndicator1.setProgress(progress);
        linearIndicator1.setLabel(progress + "% Complete");

        linearIndicator2.setProgress(progress);
        linearIndicator2.setLabel(progress + "% Complete");

        linearIndicator3.setProgress(progress);

        circularProgressIndicator1.setProgress(progress);
        circularProgressIndicator1.setLabel(progress + "%");
        circularProgressIndicator1.enableActionView(progress >= 100);
    }
}