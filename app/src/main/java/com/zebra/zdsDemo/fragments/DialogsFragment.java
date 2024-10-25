package com.zebra.zdsDemo.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.zebra.zdsDemo.R;
import com.zebra.zds.ZdsDialog;
import com.zebra.zds.ZdsSwitch;

public class DialogsFragment extends Fragment {

    private ZdsSwitch sharpStyle;
    private ZdsSwitch titleImage;
    private RadioGroup gravityRadioGroup;
    private RadioGroup actionsRadioGroup;

    public DialogsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dialogs, container, false);

        sharpStyle = root.findViewById(R.id.sharpStyle);
        titleImage = root.findViewById(R.id.titleImage);
        gravityRadioGroup = root.findViewById(R.id.gravityRadioGroup);
        actionsRadioGroup = root.findViewById(R.id.actionsRadioGroup);

        root.findViewById(R.id.showDialogButton).setOnClickListener(v -> showDialog());

        return root;
    }

    @SuppressLint("NonConstantResourceId")
    private void showDialog() {
        ZdsDialog.Builder builder = new ZdsDialog.Builder(requireContext());
        builder.setTitle("Dialog Title").setContent("Lorem ipsum dolor sit amet, conse ctetur adipiscing elit, sed do eiusm od tempor incididunt ut labore et do lore magna aliqua.");
        if (titleImage.isChecked()) {
            builder.setIcon(R.drawable.ic_warning_round);
        }
        if (gravityRadioGroup.getCheckedRadioButtonId() == R.id.gravityLeft) {
            builder.setTitleGravity(Gravity.START);
        } else {
            builder.setTitleGravity(Gravity.CENTER);
        }
        View.OnClickListener listener = v -> {

        };
        switch (actionsRadioGroup.getCheckedRadioButtonId()) {
            case R.id.oneAction:
                builder.setPositiveAction("Confirm", listener);
                break;
            case R.id.twoActions:
                builder.setPositiveAction("Confirm", listener);
                builder.setNegativeAction("Cancel", listener);
                break;
            case R.id.threeActions:
                builder.setPositiveAction("Confirm", listener);
                builder.setNegativeAction("Cancel", listener);
                builder.setNeutralAction("Learn More", listener);
                break;
        }

        builder.setIsSharp(sharpStyle.isChecked());

        builder.build().show();
    }
}