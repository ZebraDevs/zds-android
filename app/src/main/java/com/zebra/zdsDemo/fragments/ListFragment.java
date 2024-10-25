package com.zebra.zdsDemo.fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zebra.zdsDemo.R;
import com.zebra.zds.ZdsCheckBox;
import com.zebra.zds.ZdsListItem;

import java.util.Objects;

public class ListFragment extends Fragment {

    RecyclerView list;
    ZdsListAdapter adapter;

    static ZdsCheckBox imageLeftCheckBox;
    static ZdsCheckBox dividersCheckBox;
    static RadioGroup elementRightRadioGroup;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        adapter = new ZdsListAdapter();

        list = root.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        list.setHasFixedSize(true);

        imageLeftCheckBox = root.findViewById(R.id.iconLeft);
        dividersCheckBox = root.findViewById(R.id.dividers);
        elementRightRadioGroup = root.findViewById(R.id.controlsRight);

        dividersCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                list.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
            }
            else {
                list.removeItemDecorationAt(0);
            }
            adapter.notifyDataSetChanged();
        });

        imageLeftCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> adapter.notifyDataSetChanged());

        elementRightRadioGroup.setOnCheckedChangeListener((group, checkedId) -> adapter.notifyDataSetChanged());
        return root;
    }

    static class ZdsListAdapter extends RecyclerView.Adapter<ZdsListItem.ZdsViewHolder> {

        public ZdsListAdapter() {

        }

        @NonNull
        @Override
        public ZdsListItem.ZdsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            return new ZdsListItem.ZdsViewHolder(ZdsListItem.Companion.getListItem(viewGroup));
        }

        @Override
        public void onBindViewHolder(ZdsListItem.ZdsViewHolder viewHolder, final int position) {
            Objects.requireNonNull(viewHolder.getDescriptor()).setText("Descriptor " + position);
            Objects.requireNonNull(viewHolder.getContent()).setText("List Item " + position);

            viewHolder.getIconLeft().setImageTintList(ColorStateList.valueOf(Color.GRAY));
            viewHolder.getIconRight().setImageTintList(ColorStateList.valueOf(Color.GRAY));

            if (imageLeftCheckBox.isChecked()) {
                viewHolder.showIconLeft(R.drawable.ic_star_sharp);
            }
            else {
                viewHolder.hideIconLeft();
            }

            switch (elementRightRadioGroup.getCheckedRadioButtonId()) {
                case R.id.showImageRight:
                    viewHolder.showIconRight(R.drawable.ic_star_sharp);
                    break;
                case R.id.showMeta:
                    viewHolder.setMeta("Meta");
                    break;
                case R.id.showActionView:
                    viewHolder.showActionView();
                    break;
                default:
                    viewHolder.hideActionView();
                    viewHolder.hideIconRight();
                    viewHolder.setMeta("");
            }

        }

        @Override
        public int getItemCount() {
            return 16;
        }
    }
}