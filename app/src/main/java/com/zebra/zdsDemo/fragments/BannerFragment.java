package com.zebra.zdsDemo.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;

import com.zebra.zdsDemo.MainActivity;
import com.zebra.zdsDemo.R;
import com.zebra.zds.ZdsBanner;
import com.zebra.zds.ZdsButton;
import com.zebra.zds.ZdsSwitch;
import com.zebra.zds.ZdsSystemBanner;

import java.util.Objects;

public class BannerFragment extends Fragment {


    MotionLayout mainLayout;
    ZdsBanner banner;

    public BannerFragment() {
        // Required empty public constructor
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_banner, container, false);

        mainLayout = root.findViewById(R.id.motionLayout);
        banner = root.findViewById(R.id.banner);

        ((RadioGroup) root.findViewById(R.id.bannerStyle)).setOnCheckedChangeListener((group, checkedId) -> {
           switch(checkedId) {
               case R.id.none: {
                   banner.setStyle(ZdsBanner.Style.DEFAULT);
                   break;
               }
               case R.id.info: {
                   banner.setStyle(ZdsBanner.Style.INFO);
                   break;
               }
               case R.id.positive: {
                   banner.setStyle(ZdsBanner.Style.POSITIVE);
                   break;
               }
               case R.id.warning: {
                   banner.setStyle(ZdsBanner.Style.WARNING);
                   break;
               }
               case R.id.negative: {
                   banner.setStyle(ZdsBanner.Style.NEGATIVE);
                   break;
               }
           }
        });

        ((ZdsSwitch) root.findViewById(R.id.sharpStyle)).setOnCheckedChangeListener((buttonView, isChecked) -> banner.setSharp(isChecked));

        Objects.requireNonNull(banner.getTitle()).setText("Banner title");
        Objects.requireNonNull(banner.getMessage()).setText("Lorem ipsum dolor sit amet, conse ctetur cididunt ut labore et do lore magna aliqua.");

        banner.setActionOne("Action 1", v -> hideBanner());
        banner.setActionTwo("Action 2", v -> hideBanner());
        banner.setCloseAction(v -> hideBanner());

        ((ZdsButton) root.findViewById(R.id.showBanner)).setOnClickListener(v -> showBanner());

        // System banner

        ((RadioGroup) root.findViewById(R.id.systemBannerStyle)).setOnCheckedChangeListener((group, checkedId) -> {
            ZdsSystemBanner systemBanner = ((MainActivity) requireActivity()).getBanner();
            switch(checkedId) {
                case R.id.system_none: {
                    systemBanner.setStyle(ZdsSystemBanner.Style.DEFAULT);
                    break;
                }
                case R.id.system_positive: {
                    systemBanner.setStyle(ZdsSystemBanner.Style.POSITIVE);
                    break;
                }
                case R.id.system_warning: {
                    systemBanner.setStyle(ZdsSystemBanner.Style.WARNING);
                    break;
                }
                case R.id.system_negative: {
                    systemBanner.setStyle(ZdsSystemBanner.Style.NEGATIVE);
                    break;
                }
            }
        });
        ((ZdsSwitch) root.findViewById(R.id.titleCentered)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            ZdsSystemBanner systemBanner = ((MainActivity) requireActivity()).getBanner();
            systemBanner.centerTitle(isChecked);
        });

        ((ZdsButton) root.findViewById(R.id.showSystemBanner)).setOnClickListener(v -> ((MainActivity) requireActivity()).showBanner());

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ZdsSystemBanner systemBanner = ((MainActivity) requireActivity()).getBanner();
        if (systemBanner != null) {
            systemBanner.setTitleString("Banner title");
        }
    }

    private void showBanner() {
        banner.setVisibility(View.VISIBLE);
        mainLayout.transitionToEnd();
    }

    private void hideBanner() {
        mainLayout.transitionToStart();
    }
}